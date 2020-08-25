package com.gladiator.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Crops")
@NamedQuery(name="Crop.findAll", query="SELECT c FROM Crop c")
public class Crop {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cropName")
	private String cropName;

	@Column(name="cropTid")
	private String cropTid;

	@Column(name="price")
	private double price;

	//bi-directional many-to-one association to CropSell
	@OneToMany(mappedBy="crop")
	private List<CropSell> cropSells;

	//bi-directional many-to-one association to CropType
	@ManyToOne
	@JoinColumns({
		})
	private CropType cropType;

	public Crop() {
	}

	public String getCropName() {
		return this.cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropTid() {
		return this.cropTid;
	}

	public void setCropTid(String cropTid) {
		this.cropTid = cropTid;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<CropSell> getCropSells() {
		return this.cropSells;
	}

	public void setCropSells(List<CropSell> cropSells) {
		this.cropSells = cropSells;
	}

	public CropSell addCropSell(CropSell cropSell) {
		getCropSells().add(cropSell);
		cropSell.setCrop(this);

		return cropSell;
	}

	public CropSell removeCropSell(CropSell cropSell) {
		getCropSells().remove(cropSell);
		cropSell.setCrop(null);

		return cropSell;
	}

	public CropType getCropType() {
		return this.cropType;
	}

	public void setCropType(CropType cropType) {
		this.cropType = cropType;
	}
}
