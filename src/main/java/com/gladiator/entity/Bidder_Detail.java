package com.gladiator.entity;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Bidder_Details" database table.
 * 
 */
@Entity
@Table(name="Bidder_Details")
@NamedQuery(name="Bidder_Detail.findAll", query="SELECT b FROM Bidder_Detail b")
public class Bidder_Detail {
	//private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bEmail")
	private String bEmail;

	@Column(name="addLine1")
	private String addLine1;

	@Column(name="addLine2")
	private String addLine2;

	@Column(name="bAadhar")
	private String bAadhar;

	@Column(name="bAccno")
	private String bAccno;

	@Column(name="bCity")
	private String bCity;

	@Column(name="bIfsc")
	private String bIfsc;

	@Column(name="bName")
	private String bName;

	@Column(name="bPan")
	private String bPan;

	@Column(name="bPassword")
	private String bPassword;

	@Column(name="bPhno")
	private String bPhno;

	@Column(name="bPincode")
	private String bPincode;

	@Column(name="bState")
	private String bState;

	@Column(name="traderLi")
	private String traderLi;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="bidderDetail")
	private List<Document> documents;

	//bi-directional many-to-one association to LiveBid
	@OneToMany(mappedBy="bidderDetail")
	private List<LiveBid> liveBids;

	public Bidder_Detail() {
	}

	public String getBEmail() {
		return this.bEmail;
	}

	public void setBEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public String getAddLine1() {
		return this.addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return this.addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public String getBAadhar() {
		return this.bAadhar;
	}

	public void setBAadhar(String bAadhar) {
		this.bAadhar = bAadhar;
	}

	public String getBAccno() {
		return this.bAccno;
	}

	public void setBAccno(String bAccno) {
		this.bAccno = bAccno;
	}

	public String getBCity() {
		return this.bCity;
	}

	public void setBCity(String bCity) {
		this.bCity = bCity;
	}

	public String getBIfsc() {
		return this.bIfsc;
	}

	public void setBIfsc(String bIfsc) {
		this.bIfsc = bIfsc;
	}

	public String getBName() {
		return this.bName;
	}

	public void setBName(String bName) {
		this.bName = bName;
	}

	public String getBPan() {
		return this.bPan;
	}

	public void setBPan(String bPan) {
		this.bPan = bPan;
	}

	public String getBPassword() {
		return this.bPassword;
	}

	public void setBPassword(String bPassword) {
		this.bPassword = bPassword;
	}

	public String getBPhno() {
		return this.bPhno;
	}

	public void setBPhno(String bPhno) {
		this.bPhno = bPhno;
	}

	public String getBPincode() {
		return this.bPincode;
	}

	public void setBPincode(String bPincode) {
		this.bPincode = bPincode;
	}

	public String getBState() {
		return this.bState;
	}

	public void setBState(String bState) {
		this.bState = bState;
	}

	public String getTraderLi() {
		return this.traderLi;
	}

	public void setTraderLi(String traderLi) {
		this.traderLi = traderLi;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setBidderDetail(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setBidderDetail(null);

		return document;
	}

	public List<LiveBid> getLiveBids() {
		return this.liveBids;
	}

	public void setLiveBids(List<LiveBid> liveBids) {
		this.liveBids = liveBids;
	}

	public LiveBid addLiveBid(LiveBid liveBid) {
		getLiveBids().add(liveBid);
		liveBid.setBidderDetail(this);

		return liveBid;
	}

	public LiveBid removeLiveBid(LiveBid liveBid) {
		getLiveBids().remove(liveBid);
		liveBid.setBidderDetail(null);

		return liveBid;
	}

}