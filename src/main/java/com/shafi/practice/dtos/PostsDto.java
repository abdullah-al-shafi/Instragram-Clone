package com.shafi.practice.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.shafi.practice.model.User;

public class PostsDto implements Serializable{

	private long postsId;

	private String postsImage;

	private String postsText;

	private User User;

	private Date createdAt;
	
	

	/**
	 * 
	 */
	public PostsDto() {
		
	}

	/**
	 * @param postsId
	 * @param postsImage
	 * @param postsText
	 * @param user
	 * @param createdAt
	 */
	public PostsDto(long postsId, String postsImage, String postsText, com.shafi.practice.model.User user,
			Date createdAt) {
		super();
		this.postsId = postsId;
		this.postsImage = postsImage;
		this.postsText = postsText;
		this.User = user;
		this.createdAt = createdAt;
	}

	public long getPostsId() {
		return postsId;
	}

	public void setPostsId(long postsId) {
		this.postsId = postsId;
	}

	public String getPostsImage() {
		return postsImage;
	}

	public void setPostsImage(String postsImage) {
		this.postsImage = postsImage;
	}

	public String getPostsText() {
		return postsText;
	}

	public void setPostsText(String postsText) {
		this.postsText = postsText;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		this.User = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "PostsDto [postsId=" + postsId + ", postsImage=" + postsImage + ", postsText=" + postsText + ", User="
				+ User + ", createdAt=" + createdAt + "]";
	}
	
	
}
