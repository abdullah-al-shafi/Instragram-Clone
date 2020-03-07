package com.shafi.practice.controllers;




import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shafi.practice.dtos.UserDto;
import com.shafi.practice.enums.Role;

import com.shafi.practice.request.User;
import com.shafi.practice.service.PostsService;
import com.shafi.practice.service.UserService;
import com.shafi.practice.repositories.UserRepository;




@Controller
public class UserController {
	

	@Autowired
	UserService userService;
	
	@Autowired
	PostsService postsService;
	
	private final UserRepository userRepository;
	
	 @Autowired
	 ServletContext servletContext;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;

	public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/")
	public String root(Model model  , Authentication auth ) {
		
		var username =  auth.getName();
		
		com.shafi.practice.model.User user = userService.getUserByName(username);
		
		model.addAttribute("post_list",postsService.getAllPost());
		model.addAttribute("image",user.getUserImage());
		model.addAttribute("fullname",user.getUserFullName());
		return "home";
	}
	
	@GetMapping("/403")
	public String _403() {
		return "403";
	}
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam(name="error", required = false) String error) {
		generateUsers();
		model.addAttribute("error", error);
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model, @RequestParam(name="error", required = false) String error) {
		User user = new User();
		model.addAttribute("user",user);
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user")User user,Model model) {
		 
		LocalDateTime now = LocalDateTime.now();  
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user,userDto);
		userDto.setPassword(passwordEncoder.encode(user.getPassword()));
		userDto.setCreatedAt(now);
		userDto.setRole(Role.ROLE_USER);
		userDto.setUserImage("/images/profile/default_profile.jpg");
		userService.addUser(userDto);
		
		return "redirect:/login";
	}
	
    @GetMapping("/profile")
    public String getProfilePage(Model model, Authentication auth){

var username =  auth.getName();
		
		com.shafi.practice.model.User user = userService.getUserByName(username);

        model.addAttribute("user",user);


        return "user/profile";
    }
	
	@PostMapping("/user/uploadFile")
    public String uploadFiles(@RequestParam(name = "file")MultipartFile multipartFile, ModelMap modelMap){


        org.springframework.security.core.userdetails.User authenticateduser  = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var username = authenticateduser.getUsername();
        com.shafi.practice.model.User user = userService.getUserByName(authenticateduser.getUsername());
        String pictureName = "pp"+user.getUserId()+".jpg";
        // Save file on system
       if (!multipartFile.getOriginalFilename().isEmpty()) {


            try {


                File directory = new File( servletContext.getRealPath("/WEB-INF/resources/images/profile/") );


                if (!directory.exists()){
                    boolean bool = directory.mkdirs();
                    if(bool){
                        System.out.println("Directory created successfully");
                    }else{
                        System.out.println("Sorry couldn't create specified directory");
                    }
                }

                System.out.println("dir path: "+directory.getAbsolutePath());

                File outputfile = new File(directory, pictureName);

                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputfile));
                outputStream.write(multipartFile.getBytes());
                outputStream.flush();
                outputStream.close();

                user.setUserImage("/images/profile/"+pictureName);
                
                userService.updateuserProfilePicture(user);

                System.out.println("file name: "+outputfile.getName());
                modelMap.addAttribute("fileName",outputfile.getName());
                modelMap.addAttribute("photo_uri",outputfile.getAbsolutePath());
                modelMap.addAttribute("msg", "File uploaded successfully.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                modelMap.addAttribute("msg", "Failed to save file properly.");
            } catch (IOException e) {
                e.printStackTrace();
                modelMap.addAttribute("msg", "Failed to save file properly.");
            }

        } else {
            modelMap.addAttribute("msg", "Please select a valid file..");
        }


       // modelMap.addAttribute("file", multipartFile);

        return "redirect:/";

    }


	private void generateUsers() {

		if (userRepository.findByUsername("admin").isEmpty()) {
			var user = new com.shafi.practice.model.User();
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("admin"));
			user.setRole(Role.ROLE_USER);
			userRepository.save(user);
		}

	}
}
