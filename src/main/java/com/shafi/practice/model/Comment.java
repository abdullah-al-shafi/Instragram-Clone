package com.shafi.practice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*@Entity
@Table(name = "tbl_comment")
public class Comment implements Serializable{
	
	@Id
	@Column(name="comment_Id", length=20, nullable=false)
	private Long commentId;
	@Column(name="comment_body", nullable=false)
	private String commentBody;
	@OneToOne
	@JoinColumn(
			name="commented_user_id", 
			nullable = false, 
			unique=false, updatable=false)
	private User commentedUser;
	
	 * @ManyToOne
	 * 
	 * @Column(name="post_id", nullable=false) private Posts posts;
	 
	
	@Column(name = "commentAt", updatable = false)
	private LocalDateTime commentAt;
	*//**
	 * 
	 *//*
	public Comment() {
		
	}
	*//**
	 * @param commentId
	 * @param commentBody
	 * @param commentedUser
	 * @param posts
	 *//*

	public Long getCommentId() {
		return commentId;
	}
	*//**
	 * @param commentId
	 * @param commentBody
	 * @param commentedUser
	 * @param posts
	 * @param commentAt
	 *//*
	public Comment(Long commentId, String commentBody, User commentedUser, Posts posts, LocalDateTime commentAt) {
		super();
		this.commentId = commentId;
		this.commentBody = commentBody;
		this.commentedUser = commentedUser;
		this.posts = posts;
		this.commentAt = commentAt;
	}
	
	
	public LocalDateTime getCommentAt() {
		return commentAt;
	}
	public void setCommentAt(LocalDateTime commentAt) {
		this.commentAt = commentAt;
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
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentBody=" + commentBody + ", commentedUser=" + commentedUser
				+ ", posts=" + posts + ", commentAt=" + commentAt + "]";
	}


	
	
	

}
	*/
