package com.gladiator.entity;
import javax.persistence.*;


/**
 * The persistent class for the "OfficialUsers" database table.
 * 
 */
@Entity
@Table(name="OfficialUsers")
@NamedQuery(name="OfficialUser.findAll", query="SELECT o FROM OfficialUser o")
public class OfficialUser{

	@Id
	@Column(name="Email")
	private String email;

	@Column(name="password")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

