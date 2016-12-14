package com.example.eventbus.com.bwie.bean;

public class UserBean {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setPassword(String password) {

		this.password = password;
	}
}
