//package com.gladiator.entity;
//import javax.persistence.*;
//import java.util.List;
//
//
///**
// * The persistent class for the "CropType" database table.
// * 
// */
//@Entity
//@Table(name="CropType")
//@NamedQuery(name="CropType.findAll", query="SELECT c FROM CropType c")
//public class CropType {
//	//private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name="cropTid")
//	private String cropTid;
//
//	@Column(name="typeName")
//	private String typeName;
//
//	//bi-directional many-to-one association to Crop
//	@OneToMany(mappedBy="cropType")
//	private List<Crop> crops;
//
//	public CropType() {
//	}
//
//	public String getCropTid() {
//		return this.cropTid;
//	}
//
//	public void setCropTid(String cropTid) {
//		this.cropTid = cropTid;
//	}
//
//	public String getTypeName() {
//		return this.typeName;
//	}
//
//	public void setTypeName(String typeName) {
//		this.typeName = typeName;
//	}
//
//	public List<Crop> getCrops() {
//		return this.crops;
//	}
//
//	public void setCrops(List<Crop> crops) {
//		this.crops = crops;
//	}
//
//	public Crop addCrop(Crop crop) {
//		getCrops().add(crop);
//		crop.setCropType(this);
//
//		return crop;
//	}
//
//	public Crop removeCrop(Crop crop) {
//		getCrops().remove(crop);
//		crop.setCropType(null);
//
//		return crop;
//	}
//
//}
