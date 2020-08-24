package com.gladiator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
//@NamedQuery(name = "fetch-all", query = "select f from Farmer_Details as f")
public class Bidder_Details {

@Id
@Column(length=20)
private String bEmail;

@Column(length=20)
private String bName;
@Column(length=20)
private String bPhno;
@Column(length=20)
private String addLine1;
@Column(length=20)
private String addLine2;
@Column(length=20)
private String bCity;
@Column(length=20)
private String bPincode;
@Column(length=20)
private String bState;
@Column(length=20)
private String bAccno;
@Column(length=20)
private String bIfsc;
@Column(length=20)
private String bAadhar;
@Column(length=20)
private String bPan;
@Column(length=20)
private String bPassword;


public String getbEmail() {
	return bEmail;
}
public void setbEmail(String bEmail) {
	this.bEmail = bEmail;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public String getbPhno() {
	return bPhno;
}
public void setbPhno(String bPhno) {
	this.bPhno = bPhno;
}

public String getAddLine1() {
	return addLine1;
}
public void setAddLine1(String addLine1) {
	this.addLine1 = addLine1;
}
public String getAddLine2() {
	return addLine2;
}
public void setAddLine2(String addLine2) {
	this.addLine2 = addLine2;
}
public String getbCity() {
	return bCity;
}
public void setbCity(String bCity) {
	this.bCity = bCity;
}
public String getbPincode() {
	return bPincode;
}
public void setbPincode(String bPincode) {
	this.bPincode = bPincode;
}
public String getbState() {
	return bState;
}
public void setbState(String bState) {
	this.bState = bState;
}
public String getbAccno() {
	return bAccno;
}
public void setbAccno(String bAccno) {
	this.bAccno = bAccno;
}
public String getbIfsc() {
	return bIfsc;
}
public void setbIfsc(String bIfsc) {
	this.bIfsc = bIfsc;
}
public String getbAadhar() {
	return bAadhar;
}
public void setbAadhar(String bAadhar) {
	this.bAadhar = bAadhar;
}
public String getbPan() {
	return bPan;
}
public void setbPan(String bPan) {
	this.bPan = bPan;
}
public String getbPassword() {
	return bPassword;
}
public void setbPassword(String bPassword) {
	this.bPassword = bPassword;
}


}
