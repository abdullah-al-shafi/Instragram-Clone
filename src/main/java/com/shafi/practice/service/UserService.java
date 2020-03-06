package com.shafi.practice.service;

import com.shafi.practice.model.User;
import com.shafi.practice.dtos.UserDto;
import com.shafi.practice.exceptions.ResourceAlreadyExistsException;
import com.shafi.practice.repositories.UserRepository;
import com.sun.jdi.request.DuplicateRequestException;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

import java.util.List;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String userName){
    	
    	return userRepository.findByusername(userName);
    }
    
    public void addUser(UserDto userDto) {
    	checkUserInList(userDto);
    	var userEntity = new User();
    	BeanUtils.copyProperties(userDto,userEntity);
    	userRepository.save(userEntity);
    	
    }
    
    

    private void checkUserInList(UserDto userDto) {
		
    	var username = userRepository.findByusername(userDto.getUsername());
    	
    	var userEmail = userRepository.findByuserEmail(userDto.getUserEmail());
    	
    	if (username != null) {
			throw new ResourceAlreadyExistsException("UserName Already exists");
		}
		if(userEmail != null) {
			throw new DuplicateRequestException("Email Already Used");
		}
		
	}
    
    public void updateuserProfilePicture(String imageUrl,String username) {
    	
    	User user = userRepository.findByusername(username);
    	
    	user.setUserImage(imageUrl);
    	
    	userRepository.save(user);
    	
    	
    }
    


	@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));
        List<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList());

        authorities.add((GrantedAuthority) () -> userFromDb.getRole().name());

        return new org.springframework.security.core.userdetails.User(userFromDb.getUsername(), userFromDb.getPassword(), authorities);
    }
}
