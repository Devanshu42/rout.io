package com.gladiator.service;

import com.gladiator.entity.Bidder_Details;

public interface Bidder_Service {
	
	void register(Bidder_Details bdetails);

	Bidder_Details login(String email, String password);

}
