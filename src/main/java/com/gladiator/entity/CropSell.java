package com.gladiator.entity;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name="CropSell")
@NamedQuery(name = "fetch-sell-history", query = "select c from CropSell as c")
public class CropSell {

	@Id
	@SequenceGenerator(name = "User_Id_Seq", sequenceName = "User_Id_Seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Id_Seq")
	@Column
	private int sellId;

	@Column(name="adminApprove")
	private int adminApprove;

	@Column(name="baseFarmerPrice")
	private double baseFarmerPrice;

	@Column(name="cropName")
	private String cropName;

	@Column(name="expiryDate")
	private Date expiryDate;

	@Column(name="fEmail")
	private String fEmail;

	@Column(name="fertilizer")
	private String fertilizer;

	@Column(name="phVal")
	private double phVal;

	@Column(name="quantity")
	private double quantity;


	

	public int getSellId() {
		return sellId;
	}

	public void setSellId(int sellId) {
		this.sellId = sellId;
	}

	public int getAdminApprove() {
		return adminApprove;
	}

	public void setAdminApprove(int adminApprove) {
		this.adminApprove = adminApprove;
	}

	public double getBaseFarmerPrice() {
		return baseFarmerPrice;
	}

	public void setBaseFarmerPrice(double baseFarmerPrice) {
		this.baseFarmerPrice = baseFarmerPrice;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getfEmail() {
		return fEmail;
	}

	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	public String getFertilizer() {
		return fertilizer;
	}

	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}

	public double getPhVal() {
		return phVal;
	}

	public void setPhVal(double phVal) {
		this.phVal = phVal;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	

}