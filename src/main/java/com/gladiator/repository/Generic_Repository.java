package com.gladiator.repository;

import java.util.List;

import com.gladiator.entity.Crop;
import com.gladiator.entity.LiveBid;
import com.gladiator.entity.OfficialUser;

public interface Generic_Repository {
	String findAdmin(String email, String password);

	boolean isAdminPresent(String email);

	public OfficialUser findById(String email);
	public void saveCropType(Crop crop);
	
	public void approveSellRequest(int id);
	public void declineSellRequest(int id);
	
	public void AddBid(LiveBid livebid);
	public String UpdateBidChecks(LiveBid livebid);
	public boolean isBidPresent(int sellid);
	
	public List<LiveBid> getBidderHistory(String email);
	public List<LiveBid> getFarmerHistory(String email);

	void finalizeBid(int id);
}
