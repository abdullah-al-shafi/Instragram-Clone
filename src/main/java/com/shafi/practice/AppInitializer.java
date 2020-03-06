package com.shafi.practice;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class AppInitializer implements WebApplicationInitializer{
    private String TMP_FOLDER = "/tmp";
    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;
	@Override
	public void onStartup(ServletContext servletCxt) {


		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		rootContext.getEnvironment().addActiveProfile("dev");
		rootContext.refresh();

		servletCxt.addListener(new ContextLoaderListener(rootContext));

//		servletCxt.setInitParameter("spring.profiles.active", "dev");

		// Create and register the DispatcherServlet
		AnnotationConfigWebApplicationContext servletRegisterer = new AnnotationConfigWebApplicationContext();
		servletRegisterer.register(ServletConfig.class);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("servlet",
				new DispatcherServlet(servletRegisterer));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		
		File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

        MultipartConfigElement element = new MultipartConfigElement(uploadDirectory.getAbsolutePath(), MAX_UPLOAD_SIZE,MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
        registration.setMultipartConfig(element);
	}
		

}
