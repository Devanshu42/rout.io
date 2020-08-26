package com.gladiator.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gladiator.entity.Crop;
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
}
