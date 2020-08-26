package com.gladiator.dto;

public class ForgetPasswordDto {
	
	private String id;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ForgetPasswordDto [id ="+ id + ", password= " +password+"]" ;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;

}
