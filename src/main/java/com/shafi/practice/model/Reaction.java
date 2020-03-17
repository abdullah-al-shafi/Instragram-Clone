package com.shafi.practice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

  @Entity
  
  @Table(name = "tbl_reaction") 
  public class Reaction implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  
 @Column(name = "id") 
  private long reactionId;
  
  @OneToOne
  
  @JoinColumn( name="reacted_user_Id", nullable = false, updatable=false)
  private User reactedUser;
  
  @ManyToOne
  private Posts posts;

public Reaction() {
	
}

public Reaction(long reactionId, User reactedUser, Posts posts) {
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
		 