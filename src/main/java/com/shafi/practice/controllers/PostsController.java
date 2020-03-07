package com.shafi.practice.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shafi.practice.dtos.PostsDto;
import com.shafi.practice.service.PostsService;
import com.shafi.practice.service.UserService;

@Controller
public class PostsController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	PostsService postsService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user/posts")
    public String uploadFiles(@RequestParam(name = "file")MultipartFile multipartFile,@RequestParam(name = "userPosts")String userPosts, ModelMap modelMap){


        org.springframework.security.core.userdetails.User authenticateduser  = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var username = authenticateduser.getUsername();
        com.shafi.practice.model.User user = userService.getUserByName(authenticateduser.getUsername());
        
        LocalDateTime now = LocalDateTime.now();
        
        Date date = new Date();
        //This method returns the time in millis
        long timeMilli = date.getTime();
        
        String pictureName = "ps"+timeMilli+".jpg";
        
        PostsDto postsDto = new PostsDto();
        // Save file on system
       if (!multipartFile.getOriginalFilename().isEmpty()) {


            try {


                File directory = new File( servletContext.getRealPath("/WEB-INF/resources/images/posts/") );


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

                postsDto.setPostsImage("/images/posts/"+pictureName);
                postsDto.setPostsText(userPosts);
                postsDto.setUser(user);
                postsDto.setCreatedAt(now);
                user.setUserImage("/images/profile/"+pictureName);
                
                postsService.addPosts(postsDto);

                System.out.println("file name: "+outputfile.getName());
                modelMap.addAttribute("msg", "Post uploaded successfully.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                modelMap.addAttribute("msg", "Failed to save Post properly.");
            } catch (IOException e) {
                e.printStackTrace();
                modelMap.addAttribute("msg", "Failed to save Post properly.");
            }

        } else {
            modelMap.addAttribute("msg", "Please select a valid file..");
        }

       // modelMap.addAttribute("file", multipartFile);

        return "redirect:/";
    }
	
	

}
