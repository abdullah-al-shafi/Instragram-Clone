package com.shafi.practice.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.shafi.practice.model.Posts;
import com.shafi.practice.model.User;

public class CommentDto implements Serializable{
	
	
	private Long commentId;

	private String commentBody;

	private User commentedUser;

	private Posts posts;
	
	private LocalDateTime commentAt;

	public CommentDto() {
		
	}
	/**
	 * @param commentId
	 * @param commentBody
	 * @param commentedUser
	 * @param posts
	 * @param commentAt
	 */
	public CommentDto(Long commentId, String commentBody, User commentedUser, Posts posts, LocalDateTime commentAt) {
		super();
		this.commentId = commentId;
		this.commentBody = commentBody;
		this.commentedUser = commentedUser;
		this.posts = posts;
		this.commentAt = commentAt;
	}

	public Long getCommentId() {
		return commentId;
	}
	
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getCommentBody() {
		return commentBody;
	}
	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
	public User getCommentedUser() {
		return commentedUser;
	}
	public void setCommentedUser(User commentedUser) {
		this.commentedUser = commentedUser;
	}
	public Posts getPosts() {
		return posts;
	}
	public void setPosts(Posts posts) {
		this.posts = posts;
	}
	public LocalDateTime getCommentAt() {
		return commentAt;
	}
	public void setCommentAt(LocalDateTime commentAt) {
		this.commentAt = commentAt;
	}
	@Override
	public String toString() {
		return "CommentDto [commentId=" + commentId + ", commentBody=" + commentBody + ", commentedUser="
				+ commentedUser + ", posts=" + posts + ", commentAt=" + commentAt + "]";
	}

}
