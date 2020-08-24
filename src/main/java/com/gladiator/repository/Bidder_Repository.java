package com.gladiator.repository;

import java.util.List;

import com.gladiator.entity.Bidder_Details;
import com.gladiator.entity.Farmer_Details;

public interface Bidder_Repository {

	void save(Bidder_Details fdetails);

	List<Bidder_Details> findAll();

	String findByEmailAndPassword(String email, String password);

	boolean isBidderPresent(String email);

	public Bidder_Details findById(String fEmail);
}
