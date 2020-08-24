package com.gladiator.repository;

import java.util.List;

import com.gladiator.entity.Farmer_Details;

public interface Login_Repository {

	void save(Farmer_Details fdetails);

	List<Farmer_Details> findAll();

	String findByEmailAndPassword(String email, String password);

	boolean isFarmerPresent(String email);

	public Farmer_Details findById(String fEmail);
	
}
