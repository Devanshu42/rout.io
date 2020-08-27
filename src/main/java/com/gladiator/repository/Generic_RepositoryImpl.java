package com.gladiator.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gladiator.entity.Crop;
import com.gladiator.entity.LiveBid;
import com.gladiator.entity.OfficialUser;
@Repository
public class Generic_RepositoryImpl implements Generic_Repository {
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public String findAdmin(String email, String password) {
		return (String) entitymanager
				.createQuery("select o.email from OfficialUser o where o.email = :em and o.password = :pw ")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}

	@Override
	public boolean isAdminPresent(String email) {
		return (Long)
				entitymanager
				.createQuery("select count(o.email) from OfficialUser o where o.email = :em ")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	public OfficialUser findById(String email) {
		return entitymanager.find(OfficialUser.class, email);

}
	
	@Transactional
	@Override
	public void saveCropType(Crop crop) {
		// TODO Auto-generated method stub
		entitymanager.merge(crop);

	
	}

	@Override
	@Transactional
	public void approveSellRequest(int id) {
		// TODO Auto-generated method stub
		entitymanager
		.createQuery("update CropSell cs set cs.adminApprove = 1 where cs.sellId = :em")
		.setParameter("em", id)
		.executeUpdate();
		
	}
	
	@Transactional
	@Override
	public void declineSellRequest(int id) {
		// TODO Auto-generated method stub
		entitymanager
		.createQuery("update CropSell cs set cs.adminApprove = 2 where cs.sellId = :em")
		.setParameter("em", id)
		.executeUpdate();
		
		
	}
	
	@Override
	public boolean isBidPresent(int sellid) {
		return (Long)
				entitymanager
				.createQuery("select count(l.sellId) from LiveBid l where l.sellId = :sid")
				.setParameter("sid", sellid)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	@Transactional
	public void AddBid(LiveBid livebid) {
		entitymanager.merge(livebid);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public String UpdateBidChecks(LiveBid livebid) {
		
		double newbid=livebid.getCurrentPrice();
		double oldbid;
		String nemail= livebid.getbEmail();
		int sellid=livebid.getSellId();
		oldbid = (double)entitymanager
				.createQuery("select lb.currentPrice from LiveBid lb where lb.sellId = :sid")
				.setParameter("sid",sellid)
				.getSingleResult();
		
		if(newbid>oldbid) {
			entitymanager
			.createQuery("update LiveBid lb set lb.currentPrice = :nb, lb.bEmail= :em where lb.sellId= :sid")
			.setParameter("nb", newbid )
			.setParameter("em", nemail )
			.setParameter("sid", sellid )
			.executeUpdate();
			
//			entitymanager
//			.createQuery("update CropSell cs set lb.currentPrice = :nb, lb.bEmail= :em where lb.sellId= :sid")
//			.setParameter("nb", newbid )
//			.setParameter("em", nemail )
//			.setParameter("sid", sellid )
//			.executeUpdate();
//			
			return "Yay, your bid got placed over an ongoing bid";
		}
		
		return"Please enter a higher amount than the ongoing bid";
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LiveBid> getBidderHistory(String email) {
		
		return entitymanager
				.createQuery("select c.fEmail, c.cropName, c.quantity, l.currentPrice, l.bidDoneToken from LiveBid l, CropSell c where c.sellId=l.sellId and l.bEmail= :em")
				.setParameter("em",email)
				.getResultList();
		
		
		
		// TODO Auto-generated method stub
	}

	@Override
	public List<LiveBid> getFarmerHistory(String email) {
		return entitymanager
		.createQuery("select l.bEmail, c.cropName, c.quantity, l.currentPrice, l.bidDoneToken from LiveBid l, CropSell c where c.sellId=l.sellId and c.fEmail= :em")
		.setParameter("em",email)
		.getResultList();
		
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public void finalizeBid(int id) {
		
		entitymanager
		.createQuery("update LiveBid lb set lb.bidDoneToken = 1 where lb.bidId = :em")
		.setParameter("em", id)
		.executeUpdate();
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void UpdateBidBySellId() {
//		// TODO Auto-generated method stub
//		
//	}


	
}
