package com.gladiator.entity;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="CropSell")
//@NamedQuery(name="CropSell.findAll", query="SELECT c FROM CropSell c")
public class CropSell {

	@Id
	@SequenceGenerator(name = "User_Id_Seq", sequenceName = "User_Id_Seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Id_Seq")
	@Column
	private int cropId;

	@Column(name="adminApprove")
	private int adminApprove;

	@Column(name="baseFarmerPrice")
	private double baseFarmerPrice;

	@Column(name="cropName")
	private String cropName;

	@Column(name="expiryDate")
	private Timestamp expiryDate;

	@Column(name="fEmail")
	private String fEmail;

	@Column(name="fertilizer")
	private String fertilizer;

	@Column(name="phVal")
	private double phVal;

	@Column(name="quantity")
	private double quantity;


	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
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

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
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