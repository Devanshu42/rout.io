//package com.gladiator.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//
///**
// * The persistent class for the "CropBuy" database table.
// * 
// */
//@Entity
//@Table(name="CropBuy")
//@NamedQuery(name="CropBuy.findAll", query="SELECT c FROM CropBuy c")
//public class CropBuy{
//	@Id
//	@Column(name="bidId")
//	private String bidId;
//
//	@Column(name="buyPrice")
//	private double buyPrice;
//
//	//bi-directional one-to-one association to LiveBid
//	@OneToOne
//	@JoinColumns({
//		})
//	private LiveBid liveBid;
//
//	//bi-directional many-to-one association to Transaction
//	@OneToMany(mappedBy="cropBuy")
//	private List<Transaction> transactions;
//
//	public CropBuy() {
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
//	public double getBuyPrice() {
//		return this.buyPrice;
//	}
//
//	public void setBuyPrice(double buyPrice) {
//		this.buyPrice = buyPrice;
//	}
//
//	public LiveBid getLiveBid() {
//		return this.liveBid;
//	}
//
//	public void setLiveBid(LiveBid liveBid) {
//		this.liveBid = liveBid;
//	}
//
//	public List<Transaction> getTransactions() {
//		return this.transactions;
//	}
//
//	public void setTransactions(List<Transaction> transactions) {
//		this.transactions = transactions;
//	}
//
//	public Transaction addTransaction(Transaction transaction) {
//		getTransactions().add(transaction);
//		transaction.setCropBuy(this);
//
//		return transaction;
//	}
//
//	public Transaction removeTransaction(Transaction transaction) {
//		getTransactions().remove(transaction);
//		transaction.setCropBuy(null);
//
//		return transaction;
//	}
//
//}
