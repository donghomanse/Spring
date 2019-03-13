package com.dongho.accounts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INFO")
public class UserInfo {
	@Id
	@GeneratedValue
	@Column
	private Long Id;

	@Column
	private String username;
	
	@Column
	private String password;

	public UserInfo() {
		super();
	}

	public UserInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
