package com.gladiator.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gladiator.entity.CropSell;

@Repository
public class SellReq_Repository_Impl implements SellReq_Repository{
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	@Transactional
	public void save(CropSell cropsell) {
		entitymanager.merge(cropsell);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CropSell> findAll(String email) {
		return entitymanager
				.createQuery("select c.cropName,c.expiryDate,c.quantity,c.baseFarmerPrice from CropSell c where c.fEmail=:em ")
				.setParameter("em", email)
				.getResultList();		
		// TODO Auto-generated method stub
	}

	@Override
	public List<CropSell> findApproved(String email) {
		return  entitymanager
				.createQuery("select c.cropName,c.baseFarmerPrice from CropSell c where c.adminApprove = 1 and c.fEmail=:em ")
				.setParameter("em", email)
				.getResultList();
	}
	
	@Override
	public List<CropSell> findNotApproved() {
		return  entitymanager
				.createQuery("select c.cropName,c.cropTypeName,cs.baseFarmerPrice from Crop c,CropSell cs where c.cropName=cs.cropName and cs.adminApprove=0")
				.getResultList();
	}

	

}
