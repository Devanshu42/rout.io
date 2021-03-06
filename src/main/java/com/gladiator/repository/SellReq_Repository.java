package com.gladiator.repository;

import java.util.List;

import com.gladiator.entity.CropSell;
import com.gladiator.entity.LiveBid;

public interface SellReq_Repository {
	
	
	void save(CropSell cropsell);

	List<CropSell> findAll(String email);
	
	List<CropSell> findApproved(String email);
	
	public List<CropSell> findNotApproved();

	List<CropSell> findAll();
	
	List<CropSell> findCropNames(String croptype);
	
	List<LiveBid> findAllBids();
	

}
