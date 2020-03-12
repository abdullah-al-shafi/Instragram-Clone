package com.shafi.practice.controllers;




import org.apache.log4j.Logger;
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

	private Logger logger = Logger.getLogger(PostsController.class);
	
	private final CommentService commentService ;
	
	public CommentRestController(CommentService commentService) {
		this.commentService = commentService;
	}
	
    @PostMapping("/post/like")
    public ResponseEntity<?> addNewLike(@RequestParam(name = "postId")long postId, @RequestParam(name = "userId") long userId){

        logger.info("userId: "+userId+" postId: "+postId);

        long likeid = 0;
//        boolean isExists = postService.isAlreadyLiked(postId,userId);
//        if (isExists){
//            long val = postService.removeLike(postId,userId);
//            logger.info("removed val: "+val);
//
//        }else {
//            likeid =   postService.addNewLike(postId,userId);
//        }

        /*return "redirect:/index";*/

        return new ResponseEntity<>(likeid, HttpStatus.OK);
    }
}
