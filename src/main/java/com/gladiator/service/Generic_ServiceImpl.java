package com.gladiator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gladiator.entity.Farmer_Details;
import com.gladiator.entity.OfficialUser;
import com.gladiator.exceptions.FarmerServiceException;
import com.gladiator.repository.Generic_Repository;

@Service
public class Generic_ServiceImpl implements Generic_Service {
	
	@Autowired
	private Generic_Repository gRepo;

	@Override
	public OfficialUser login(String email, String password) {
		try {
			if(!gRepo.isAdminPresent(email))
				throw new FarmerServiceException("Admin credentials wrong");
			String aemail =  gRepo.findAdmin(email, password);
			OfficialUser adetails = gRepo.findById(aemail);
			return adetails;
		}
		catch(EmptyResultDataAccessException e) {
			throw new FarmerServiceException("Incorrect Username/Password");
		}
	}
	}


