package com.gladiator.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the "LiveBid" database table.
 * 
 */
@Entity
@Table(name="LiveBid")
@NamedQuery(name="LiveBid.findAll", query="SELECT l FROM LiveBid l")
public class LiveBid {
	//private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bidId")
	private String bidId;

	@Column(name="basePrice")
	private double basePrice;

	@Column(name="bEmail")
	private String bEmail;

	@Column(name="BidPrice")
	private double bidPrice;

	@Lob
	@Column(name="bidStatus")
	private byte[] bidStatus;

	@Column(name="cropId")
	private String cropId;

	@Column(name="time")
	private Timestamp time;

	@Column(name="transBidI")
	private BigDecimal transBidId;

	//bi-directional one-to-one association to CropBuy
	@OneToOne(mappedBy="liveBid")
	private CropBuy cropBuy;

	//bi-directional many-to-one association to Bidder_Detail
	@ManyToOne
	@JoinColumns({
		})
	private Bidder_Detail bidderDetail;

	//bi-directional many-to-one association to CropSell
	@ManyToOne
	@JoinColumns({
		})
	private CropSell cropSell;

	public LiveBid() {
	}

	public String getBidId() {
		return this.bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public double getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getBEmail() {
		return this.bEmail;
	}

	public void setBEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public double getBidPrice() {
		return this.bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public byte[] getBidStatus() {
		return this.bidStatus;
	}

	public void setBidStatus(byte[] bidStatus) {
		this.bidStatus = bidStatus;
	}

	public String getCropId() {
		return this.cropId;
	}

	public void setCropId(String cropId) {
		this.cropId = cropId;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public BigDecimal getTransBidId() {
		return this.transBidId;
	}

	public void setTransBidId(BigDecimal transBidId) {
		this.transBidId = transBidId;
	}

	public CropBuy getCropBuy() {
		return this.cropBuy;
	}

	public void setCropBuy(CropBuy cropBuy) {
		this.cropBuy = cropBuy;
	}

	public Bidder_Detail getBidderDetail() {
		return this.bidderDetail;
	}

	public void setBidderDetail(Bidder_Detail bidderDetail) {
		this.bidderDetail = bidderDetail;
	}

	public CropSell getCropSell() {
		return this.cropSell;
	}

	public void setCropSell(CropSell cropSell) {
		this.cropSell = cropSell;
	}

}




