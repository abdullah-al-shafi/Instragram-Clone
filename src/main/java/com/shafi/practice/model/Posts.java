package com.shafi.practice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_post")
public class Posts implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long postsId;
	
	@Column(name = "userimage_url")
	private String postsImage;
	
	@Column(name = "postsText")
	private String postsText;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "createdAt", updatable = false)
	private LocalDateTime createdAt;

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
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @param postsId
	 * @param postsImage
	 * @param postsText
	 * @param user
	 * @param createdAt
	 */
	public Posts(long postsId, String postsImage, String postsText, com.shafi.practice.model.User user,
			LocalDateTime createdAt) {
		super();
		this.postsId = postsId;
		this.postsImage = postsImage;
		this.postsText = postsText;
		this.user = user;
		this.createdAt = createdAt;
	}

	/**
	 * 
	 */
	public Posts() {
		
	}

	@Override
	public String toString() {
		return "Posts [postsId=" + postsId + ", postsImage=" + postsImage + ", postsText=" + postsText + ", User="
				+ user + ", createdAt=" + createdAt + "]";
	}
	
	
}
