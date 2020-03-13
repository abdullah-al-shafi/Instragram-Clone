package com.shafi.practice.controllers;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shafi.practice.service.CommentService;
import com.shafi.practice.service.ReactionService;



@RestController
@RequestMapping("/api/v1")
public class CommentRestController {

	private Logger logger = Logger.getLogger(PostsController.class);
	
	@Autowired
	private  CommentService commentService ;
	
	@Autowired
	private  ReactionService reactionService;
	
//	public CommentRestController(ReactionService reactionService) {
//		this.commentService = new CommentService();
//		this.reactionService = new ReactionService();
//		
//	}
//	
//	public CommentRestController(CommentService commentService) {
//		this.commentService = new CommentService();
//		this.reactionService = new ReactionService();
//	
//	}
	
    @PostMapping("/post/like")
    public ResponseEntity<?> addNewLike(@RequestParam(name = "postId")long postId, @RequestParam(name = "userId") long userId){

        logger.info("userId: "+userId+" postId: "+postId);

        long likeid = 0;
        
        boolean isExists = reactionService.isAlreadyLiked(postId,userId);
        if (isExists){
            long val = reactionService.removeLike(postId,userId);
            logger.info("removed val: "+val);
        }else {
            likeid =   reactionService.addNewLike(postId,userId);
        }

        /*return "redirect:/index";*/

        return new ResponseEntity<>(likeid, HttpStatus.OK);
    }
}
