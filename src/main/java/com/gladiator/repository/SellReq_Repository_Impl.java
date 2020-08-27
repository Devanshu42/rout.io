package com.gladiator.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gladiator.entity.CropSell;
import com.gladiator.entity.LiveBid;

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
	public List<CropSell> findAll() {
		return entitymanager
				.createQuery("select c.sellId, c.cropName,c.expiryDate,c.quantity,c.baseFarmerPrice, cr.cropTypeName, c.adminApprove from CropSell c, Crop cr where c.cropName=cr.cropName and c.adminApprove=0")
				.getResultList();		
		// TODO Auto-generated method stub
	}

	@Override
	public List<CropSell> findAll(String email) {
		return entitymanager
				.createQuery("select c.cropName,c.expiryDate,c.quantity,c.baseFarmerPrice, l.currentPrice from CropSell c, LiveBid l where c.fEmail=:em and c.sellId=l.sellId ")
				.setParameter("em", email)
				.getResultList();		
		// TODO Auto-generated method stub
	}

	@Override
	public List<CropSell> findApproved(String email) {
		return entitymanager
				.createQuery("select c.cropName, c.quantity, l.currentPrice, l,bEmail from CropSell c, LiveBid l where c.sellId=l.sellId and l.bidDoneToken=1")
				.getResultList();
	}
	
	@Override
	public List<CropSell> findNotApproved() {
		return  entitymanager
				.createQuery("select c.sellId, c.quantity, c.cropName, c.baseFarmerPrice, c.expiryDate, l.currentPrice from CropSell c LEFT OUTER JOIN LiveBid l ON (c.sellId=l.sellId) where c.adminApprove=1 and l.bidDoneToken=0 OR l.bidDoneToken=NULL")
				.getResultList();
	}
	
	@Override
	public List<CropSell> findCropNames(String croptype) {
		System.out.println("CropType "+croptype);
		return  entitymanager
				.createQuery("select c.cropName from Crop c where c.cropTypeName=:ct")
				.setParameter("ct", croptype)
				.getResultList();
		
	}

	@Override
	public List<LiveBid> findAllBids() {
		
		return entitymanager
				.createQuery("select l.bidId, c.fEmail, l.bEmail, c.cropName, l.currentPrice from LiveBid l, CropSell c where l.sellId=c.sellId and l.bidDoneToken=0")
				.getResultList();
		// TODO Auto-generated method stub
	}

	

}
