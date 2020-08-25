package com.gladiator.entity;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "CropSell" database table.
 * 
 */

@Entity
@Table(name="CropSell")
@NamedQuery(name="CropSell.findAll", query="SELECT c FROM CropSell c")
public class CropSell {

	@Id
	@Column(name="cropId")
	private String cropId;

	@Lob
	@Column(name="adminApprove")
	private byte[] adminApprove;

	@Column(name="baseFarmerPrice")
	private Timestamp baseFarmerPrice;

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

	//bi-directional many-to-one association to Crop
	@ManyToOne
	@JoinColumns({
		})
	private Crop crop;

	//bi-directional many-to-one association to Farmer_Detail
	@ManyToOne
	@JoinColumns({
		})
	private Farmer_Detail farmerDetail;

	//bi-directional many-to-one association to LiveBid
	@OneToMany(mappedBy="cropSell")
	private List<LiveBid> liveBids;

	public CropSell() {
	}

	public String getCropId() {
		return this.cropId;
	}

	public void setCropId(String cropId) {
		this.cropId = cropId;
	}

	public byte[] getAdminApprove() {
		return this.adminApprove;
	}

	public void setAdminApprove(byte[] adminApprove) {
		this.adminApprove = adminApprove;
	}

	public Timestamp getBaseFarmerPrice() {
		return this.baseFarmerPrice;
	}

	public void setBaseFarmerPrice(Timestamp baseFarmerPrice) {
		this.baseFarmerPrice = baseFarmerPrice;
	}

	public String getCropName() {
		return this.cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getFEmail() {
		return this.fEmail;
	}

	public void setFEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	public String getFertilizer() {
		return this.fertilizer;
	}

	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}

	public double getPhVal() {
		return this.phVal;
	}

	public void setPhVal(double phVal) {
		this.phVal = phVal;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Crop getCrop() {
		return this.crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Farmer_Detail getFarmerDetail() {
		return this.farmerDetail;
	}

	public void setFarmerDetail(Farmer_Detail farmerDetail) {
		this.farmerDetail = farmerDetail;
	}

	public List<LiveBid> getLiveBids() {
		return this.liveBids;
	}

	public void setLiveBids(List<LiveBid> liveBids) {
		this.liveBids = liveBids;
	}

	public LiveBid addLiveBid(LiveBid liveBid) {
		getLiveBids().add(liveBid);
		liveBid.setCropSell(this);

		return liveBid;
	}

	public LiveBid removeLiveBid(LiveBid liveBid) {
		getLiveBids().remove(liveBid);
		liveBid.setCropSell(null);

		return liveBid;
	}

}