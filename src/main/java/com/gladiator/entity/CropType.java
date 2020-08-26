package com.gladiator.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CropType")
@NamedQuery(name="CropType.findAll", query="SELECT c FROM CropType c")
public class CropType {
	
	@Id
	@Column(name="cropTid")
	private int cropTid;

	@Column(name="typeName")
	private String typeName;

	

	public int getCropTid() {
		return cropTid;
	}

	public void setCropTid(int cropTid) {
		this.cropTid = cropTid;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	
}
