package com.gladiator.repository;

import com.gladiator.entity.Crop;
import com.gladiator.entity.OfficialUser;

public interface Generic_Repository {
	String findAdmin(String email, String password);

	boolean isAdminPresent(String email);

	public OfficialUser findById(String email);
	public void saveCropType(Crop crop);

}
