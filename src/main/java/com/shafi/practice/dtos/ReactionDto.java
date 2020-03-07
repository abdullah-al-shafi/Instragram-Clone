package com.shafi.practice.dtos;

import java.io.Serializable;


import com.shafi.practice.model.Posts;
import com.shafi.practice.model.User;

public class ReactionDto implements Serializable{
	
	private long reactionId;

	private User reactedUser;

	private Posts posts;

	/**
	 * 
	 */
	public ReactionDto() {
		
	}

	/**
	 * @param reactionId
	 * @param reactedUser
	 * @param posts
	 */
	public ReactionDto(long reactionId, User reactedUser, Posts posts) {
		super();
		this.reactionId = reactionId;
		this.reactedUser = reactedUser;
		this.posts = posts;
	}

	public long getReactionId() {
		return reactionId;
	}

	public void setReactionId(long reactionId) {
		this.reactionId = reactionId;
	}

	public User getReactedUser() {
		return reactedUser;
	}

	public void setReactedUser(User reactedUser) {
		this.reactedUser = reactedUser;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Reaction [reactionId=" + reactionId + ", reactedUser=" + reactedUser + ", posts=" + posts + "]";
	}
	
	
	

}
