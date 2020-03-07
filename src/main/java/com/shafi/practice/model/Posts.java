package com.shafi.practice.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Date createdAt;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = CascadeType.ALL)
    private List<Comment> comments  = new ArrayList();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = CascadeType.ALL)
    private List<Reaction> reactions  = new ArrayList();

	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
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
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @param postsId
	 * @param postsImage
	 * @param postsText
	 * @param user
	 * @param createdAt
	 */


	/**
	 * 
	 */
	public Posts() {
		
	}

	public Posts(long postsId, String postsImage, String postsText, User user, Date createdAt,
			List<Comment> comments, List<Reaction> reactions) {
		super();
		this.postsId = postsId;
		this.postsImage = postsImage;
		this.postsText = postsText;
		this.user = user;
		this.createdAt = createdAt;
		this.comments = comments;
		this.reactions = reactions;
	}

	@Override
	public String toString() {
		return "Posts [postsId=" + postsId + ", postsImage=" + postsImage + ", postsText=" + postsText + ", user="
				+ user + ", createdAt=" + createdAt + ", comments=" + comments + ", reactions=" + reactions + "]";
	}
		
}
