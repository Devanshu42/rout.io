//package com.gladiator.entity;
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
///**
// * The persistent class for the "Transaction" database table.
// * 
// */
//@Entity
//@Table(name="Transaction")
//@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
//public class Transaction{
//
//	@Id
//	@Column(name="transactionId")
//	private String transactionId;
//
//	@Column(name="bidId")
//	private String bidId;
//
//	@Column(name="date")
//	private Timestamp date;
//
//	@Lob
//	@Column(name="status")
//	private byte[] status;
//
//	//bi-directional many-to-one association to CropBuy
//	@ManyToOne
//	@JoinColumns({
//		})
//	private CropBuy cropBuy;
//
//	public Transaction() {
//	}
//
//	public String getTransactionId() {
//		return this.transactionId;
//	}
//
//	public void setTransactionId(String transactionId) {
//		this.transactionId = transactionId;
//	}
//
//	public String getBidId() {
//		return this.bidId;
//	}
//
//	public void setBidId(String bidId) {
//		this.bidId = bidId;
//	}
//
//	public Timestamp getDate() {
//		return this.date;
//	}
//
//	public void setDate(Timestamp date) {
//		this.date = date;
//	}
//
//	public byte[] getStatus() {
//		return this.status;
//	}
//
//	public void setStatus(byte[] status) {
//		this.status = status;
//	}
//
//	public CropBuy getCropBuy() {
//		return this.cropBuy;
//	}
//
//	public void setCropBuy(CropBuy cropBuy) {
//		this.cropBuy = cropBuy;
//	}
//
//}