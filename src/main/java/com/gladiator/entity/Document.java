//package com.gladiator.entity;
//
//import javax.persistence.*;
//
//
///**
// * The persistent class for the "Documents" database table.
// * 
// */
//@Entity
//@Table(name="Documents")
//@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
//public class Document{
//
//	@Column(name="aadhar")
//	private String aadhar;
//
//	@Lob
//	@Column(name="approveStatus")
//	private byte[] approveStatus;
//
//	@Column(name="bEmail")
//	private String bEmail;
//
//	@Column(name="certificateFarmer")
//	private String certificateFarmer;
//
//	@Column(name="fEmail")
//	private String fEmail;
//
//	@Column(name="pan")
//	private String pan;
//
//	@Column(name="traderLi")
//	private String traderLi;
//
//	//bi-directional many-to-one association to Bidder_Detail
//	@ManyToOne
////	@JoinColumns({
////		})
//	private Bidder_Detail bidderDetail;
//
//	//bi-directional many-to-one association to Farmer_Detail
//	@ManyToOne
////	@JoinColumns({
////		})
//	private Farmer_Detail farmerDetail;
//
//	public Document() {
//	}
//
//	public String getAadhar() {
//		return this.aadhar;
//	}
//
//	public void setAadhar(String aadhar) {
//		this.aadhar = aadhar;
//	}
//
//	public byte[] getApproveStatus() {
//		return this.approveStatus;
//	}
//
//	public void setApproveStatus(byte[] approveStatus) {
//		this.approveStatus = approveStatus;
//	}
//
//	public String getBEmail() {
//		return this.bEmail;
//	}
//
//	public void setBEmail(String bEmail) {
//		this.bEmail = bEmail;
//	}
//
//	public String getCertificateFarmer() {
//		return this.certificateFarmer;
//	}
//
//	public void setCertificateFarmer(String certificateFarmer) {
//		this.certificateFarmer = certificateFarmer;
//	}
//
//	public String getFEmail() {
//		return this.fEmail;
//	}
//
//	public void setFEmail(String fEmail) {
//		this.fEmail = fEmail;
//	}
//
//	public String getPan() {
//		return this.pan;
//	}
//
//	public void setPan(String pan) {
//		this.pan = pan;
//	}
//
//	public String getTraderLi() {
//		return this.traderLi;
//	}
//
//	public void setTraderLi(String traderLi) {
//		this.traderLi = traderLi;
//	}
//
//	public Bidder_Detail getBidderDetail() {
//		return this.bidderDetail;
//	}
//
//	public void setBidderDetail(Bidder_Detail bidderDetail) {
//		this.bidderDetail = bidderDetail;
//	}
//
//	public Farmer_Detail getFarmerDetail() {
//		return this.farmerDetail;
//	}
//
//	public void setFarmerDetail(Farmer_Detail farmerDetail) {
//		this.farmerDetail = farmerDetail;
//	}
//
//}