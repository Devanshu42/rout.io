
package com.gladiator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gladiator.entity.CropType;
import com.gladiator.repository.Generic_Repository;



@SpringBootTest
class GladiatorApplicationTests {
	
	@Autowired
	private Generic_Repository genericrepo;
	
	@Test
	void add() {
			CropType ct=new CropType();
			ct.setTypeName("CashCrop");
			ct.setCropTid(1);
			genericrepo.saveCropType(ct);
			
			CropType ct1=new CropType();
			ct1.setTypeName("FoodCrop");
			ct1.setCropTid(2);
			genericrepo.saveCropType(ct1);
			
			CropType ct2=new CropType();
			ct2.setTypeName("HorticultureCrop");
			ct2.setCropTid(3);
			genericrepo.saveCropType(ct2);
			
			CropType ct3=new CropType();
			ct3.setTypeName("PlantationCrop");
			ct3.setCropTid(4);
			genericrepo.saveCropType(ct3);
		}
	}