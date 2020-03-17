package com.shafi.practice.service;


import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shafi.practice.model.User;
import com.shafi.practice.model.Posts;
import com.shafi.practice.model.Reaction;
import com.shafi.practice.repositories.ReactionRepository;

@Service
public class ReactionService {

	@Autowired
	private  ReactionRepository reactionRepository;
	
    public long addNewLike(long postId, long userId) {
       
        Reaction like = new Reaction();

        Posts post = new Posts();
        post.setPostsId(postId);
        User user = new User();
        user.setUserId(userId);

        like.setPosts(post);
        like.setReactedUser(user);
        
        var likeEntity = new Reaction();
    	BeanUtils.copyProperties(like,likeEntity);
        
    	reactionRepository.save(likeEntity);
    	
    	List<Reaction> reactions = reactionRepository.findByPosts_postsId(postId);

        long likeTotal = reactions.size();
        return likeTotal;
        
    }
    
    public long totalReaction(long postsId) {
    	
    	List<Reaction> reactions = reactionRepository.findByPosts_postsId(postsId);
        long likeTotal = reactions.size();
        return likeTotal;
    }
	
	public boolean isAlreadyLiked(long postId, long userId) {
		var reacton = reactionRepository.findByPosts_postsIdAndReactedUser_userId(postId, userId);
		if (reacton != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional
    public long removeLike(long postId, long userId) {
		var reactonEntity = reactionRepository.findByPosts_postsIdAndReactedUser_userId(postId, userId);
		Reaction reaction = new Reaction();
		BeanUtils.copyProperties(reactonEntity,reaction);
		reactionRepository.delete(reaction);
        long val = reaction.getReactionId();
        return val;

    }
	
	
	
	
}
