package com.gladiator.repository;

import java.util.List;

import com.gladiator.entity.CropSell;

public interface SellReq_Repository {
	
	
	void save(CropSell cropsell);

	List<CropSell> findAll();
	
	List<CropSell> findApproved();
	

}
