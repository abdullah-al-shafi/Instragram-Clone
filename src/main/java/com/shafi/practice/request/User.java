package com.shafi.practice.request;

import java.io.Serializable;



public class User implements Serializable{

	private String userEmail;

	private String userFullName;

	private String username;

	private String password;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String userEmail, String userFullName, String username, String password) {
		super();
		this.userEmail = userEmail;
		this.userFullName = userFullName;
		this.username = username;
		this.password = password;
	}

	public User() {
		
	}
	
	
}
