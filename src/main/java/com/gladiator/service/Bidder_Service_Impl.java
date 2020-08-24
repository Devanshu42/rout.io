package com.gladiator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.gladiator.entity.Bidder_Details;
import com.gladiator.exceptions.FarmerServiceException;
import com.gladiator.repository.Bidder_Repository;

@Repository
public class Bidder_Service_Impl implements Bidder_Service {
	
	@Autowired
	private Bidder_Repository brepository;

	@Override
	public void register(Bidder_Details bdetails) {
		if(!brepository.isBidderPresent(bdetails.getbEmail())) {
			brepository.save(bdetails);
		}
		else
			throw new FarmerServiceException("Bidder Already Registered");
		
	}

	@Override
	public Bidder_Details login(String email, String password) {
		System.out.println("email pas in login and pass  "+email+password);
		try {
			if(!brepository.isBidderPresent(email))
				throw new FarmerServiceException("Bidder not registered!");
			String bemail =  brepository.findByEmailAndPassword(email, password);
			Bidder_Details bdetails = brepository.findById(bemail);
			return bdetails;
		}
		catch(EmptyResultDataAccessException e) {
			throw new FarmerServiceException("Incorrect Username/Password");
		}
	}

}
