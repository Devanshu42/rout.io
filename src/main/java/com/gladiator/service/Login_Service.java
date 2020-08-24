package com.gladiator.service;

import com.gladiator.entity.Farmer_Details;

public interface Login_Service {

	void register(Farmer_Details fdetails);

	Farmer_Details login(String email, String password);
}
