package com.gladiator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
//@NamedQuery(name = "fetch-all", query = "select f from Farmer_Details as f")
public class Farmer_Details {

@Id
@Column(length=20)
private String fEmail;

@Column(length=20)
private String fName;
@Column(length=20)
private String fPhno;
@Column(length=20)
private String addLine1;
@Column(length=20)
private String addLine2;
@Column(length=20)
private String fCity;
@Column(length=20)
private String fPincode;
@Column(length=20)
private String fState;
@Column(length=20)
private String fAccno;
@Column(length=20)
private String fIfsc;
@Column(length=20)
private String fAadhar;
@Column(length=20)
private String fPan;
@Column(length=20)
private String certificate;
@Column(length=20)
private String fPassword;

public String getfPassword() {
	return fPassword;
}
public void setfPassword(String fPassword) {
	this.fPassword = fPassword;
}
public String getfEmail() {
	return fEmail;
}
public void setfEmail(String fEmail) {
	this.fEmail = fEmail;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getfPhno() {
	return fPhno;
}
public void setfPhno(String fPhno) {
	this.fPhno = fPhno;
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
public String getfCity() {
	return fCity;
}
public void setfCity(String fCity) {
	this.fCity = fCity;
}
public String getfPincode() {
	return fPincode;
}
public void setfPincode(String fPincode) {
	this.fPincode = fPincode;
}
public String getfState() {
	return fState;
}
public void setfState(String fState) {
	this.fState = fState;
}
public String getfAccno() {
	return fAccno;
}
public void setfAccno(String fAccno) {
	this.fAccno = fAccno;
}
public String getfIfsc() {
	return fIfsc;
}
public void setfIfsc(String fIfsc) {
	this.fIfsc = fIfsc;
}
public String getfAadhar() {
	return fAadhar;
}
public void setfAadhar(String fAadhar) {
	this.fAadhar = fAadhar;
}
public String getfPan() {
	return fPan;
}
public void setfPan(String fPan) {
	this.fPan = fPan;
}
public String getCertificate() {
	return certificate;
}
public void setCertificate(String certificate) {
	this.certificate = certificate;
}


}
