package com.gladiator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gladiator.entity.Farmer_Details;
import com.gladiator.exceptions.FarmerServiceException;
import com.gladiator.repository.Login_Repository;

@Service
public class Login_Service_Impl implements Login_Service {
	
	@Autowired
	private Login_Repository repository;
	
	@Override
	public void register(Farmer_Details fdetails) {
		if(!repository.isFarmerPresent(fdetails.getfEmail())) {
			repository.save(fdetails);
		}
		else
			throw new FarmerServiceException("Farmer Already Registered");
	}

	@Override
	public Farmer_Details login(String email, String password) {
		System.out.println(email+password);
		try {
			if(!repository.isFarmerPresent(email))
				throw new FarmerServiceException("Farmer not registered!");
			String fEmail =  repository.findByEmailAndPassword(email, password);
			Farmer_Details fdetails = repository.findById(fEmail);
			return fdetails;
		}
		catch(EmptyResultDataAccessException e) {
			throw new FarmerServiceException("Incorrect Username/Password");
		}
	}

}
