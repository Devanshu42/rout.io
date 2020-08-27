package com.gladiator.entity;
import javax.persistence.*;

@Entity
@Table(name="LiveBid")
public class LiveBid {
	
	@Id
	@Column(name="bidId")
	@SequenceGenerator(name = "bid_Id_Seq", sequenceName = "bid_Id_Seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_Id_Seq")
	private int bidId;
	
	@Column(name="sellId")
	private int sellId;
	
	@Column(name="bEmail")
	private String bEmail; 
	

	@Column(name="CurrentPrice")
	private double currentPrice=0.0;
	

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getSellId() {
		return sellId;
	}

	public void setSellId(int sellId) {
		this.sellId = sellId;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	
	
}