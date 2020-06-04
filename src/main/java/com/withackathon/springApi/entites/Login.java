package com.withackathon.springApi.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "member_information")
public class Login {

	private String uniqueId;
	private String password;
	
	public Login()
	{
		
	}

	public Login(String uniqueId, String password) {
		this.password = password;
		this.uniqueId = uniqueId;
	}

	@Id
	@Column(name = "unique_id", nullable = false)
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Column(name = "password",nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
