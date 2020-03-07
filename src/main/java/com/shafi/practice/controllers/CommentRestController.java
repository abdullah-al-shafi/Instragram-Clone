package com.shafi.practice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shafi.practice.service.CommentService;

@RestController
@RequestMapping("/api/v1")
public class CommentRestController {

	private final CommentService commentService ;
	
	public CommentRestController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@PostMapping(value = "/player/search")
    public void  commentAdd(@RequestParam(name = "query") String query) {
		commentService.addComment(query);
        
    }
}
