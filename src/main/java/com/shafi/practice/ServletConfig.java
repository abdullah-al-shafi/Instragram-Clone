package com.shafi.practice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.shafi.practice.controllers" })
public class ServletConfig implements WebMvcConfigurer{

	// Configuration to render VIEWS
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// Configuration to render STATIC CONTENTS (IMAGE, CSS, JS)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler for -

		// IMAGES
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		
		//POST IMAGES
	    registry.addResourceHandler("/images/posts/**").addResourceLocations("/WEB-INF/resources/images/posts/");
		
		registry.addResourceHandler("/images/profile/**").addResourceLocations("/WEB-INF/resources/images/profile/");
		
		//font
		registry.addResourceHandler("/font/**").addResourceLocations("/WEB-INF/resources/font/");
		
		// CSS
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");

		// JAVASCRIPT
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
	}
}
