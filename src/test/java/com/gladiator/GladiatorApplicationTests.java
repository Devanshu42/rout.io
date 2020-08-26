
package com.gladiator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gladiator.entity.Crop;
import com.gladiator.repository.Generic_Repository;



@SpringBootTest
class GladiatorApplicationTests {
	
	@Autowired
	private Generic_Repository genericrepo;
	
	@Test
	void add() {
			Crop ct=new Crop();
			ct.setCropTypeName("CashCrop");
			ct.setCropName("SugarCane");
			ct.setPrice(100.00);
			genericrepo.saveCropType(ct);
			
			Crop ct1=new Crop();
			ct1.setCropTypeName("CashCrop");
			ct1.setCropName("Tobacco");
			ct1.setPrice(200.0);
			genericrepo.saveCropType(ct1);
			
			Crop ct2=new Crop();
			ct2.setCropTypeName("CashCrop");
			ct2.setCropName("Jute");
			ct2.setPrice(300.0);
			genericrepo.saveCropType(ct2);
			
			Crop ct3=new Crop();
			ct3.setCropTypeName("CashCrop");
			ct3.setCropName("Cotton");
			ct3.setPrice(250.0);
			genericrepo.saveCropType(ct3);
			
			Crop ct4=new Crop();
			ct4.setCropTypeName("CashCrop");
			ct4.setCropName("OilSeeds");
			ct4.setPrice(350.0);
			genericrepo.saveCropType(ct4);
			
			Crop ct5=new Crop();
			ct5.setCropTypeName("FoodCrop");
			ct5.setCropName("Wheat");
			ct5.setPrice(40);
			genericrepo.saveCropType(ct5);
			
			Crop ct6=new Crop();
			ct6.setCropTypeName("FoodCrop");
			ct6.setCropName("Rice");
			ct6.setPrice(50);
			genericrepo.saveCropType(ct6);
			
			Crop ct7=new Crop();
			ct7.setCropTypeName("FoodCrop");
			ct7.setCropName("Maize");
			ct7.setPrice(150.0);
			genericrepo.saveCropType(ct7);
			
			Crop ct8=new Crop();
			ct8.setCropTypeName("FoodCrop");
			ct8.setCropName("Milletss");
			ct8.setPrice(100.0);
			genericrepo.saveCropType(ct8);
			
			Crop ct9=new Crop();
			ct9.setCropTypeName("FoodCrop");
			ct9.setCropName("Pulses");
			ct9.setPrice(90.0);
			genericrepo.saveCropType(ct9);
			
			Crop ct10=new Crop();
			ct10.setCropTypeName("HorticultureCrop");
			ct10.setCropName("Apple");
			ct10.setPrice(150.0);
			genericrepo.saveCropType(ct10);
			
			Crop ct11=new Crop();
			ct11.setCropTypeName("HorticultureCrop");
			ct11.setCropName("Banana");
			ct11.setPrice(50.0);
			genericrepo.saveCropType(ct11);
			
			Crop ct12=new Crop();
			ct12.setCropTypeName("PlantationCrop");
			ct12.setCropName("Coffee");
			ct12.setPrice(200.0);
			genericrepo.saveCropType(ct12);
			
			Crop ct13=new Crop();
			ct13.setCropTypeName("PlantationCrop");
			ct13.setCropName("Tea");
			ct13.setPrice(150.0);
			genericrepo.saveCropType(ct13);
			
			Crop ct14=new Crop();
			ct14.setCropTypeName("PlantationCrop");
			ct14.setCropName("Coconut");
			ct14.setPrice(120.0);
			genericrepo.saveCropType(ct14);
			
			Crop ct15=new Crop();
			ct15.setCropTypeName("PlantationCrop");
			ct15.setCropName("Rubber");
			ct15.setPrice(600.0);
			genericrepo.saveCropType(ct15);
		}

	}