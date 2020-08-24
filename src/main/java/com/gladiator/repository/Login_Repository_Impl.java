package com.gladiator.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gladiator.entity.Farmer_Details;

@Repository
public class Login_Repository_Impl implements Login_Repository {

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	@Transactional
	public void save(Farmer_Details fdetails) {
		entitymanager.merge(fdetails);
	}

	@Override
	public List<Farmer_Details> findAll() {
		return entitymanager
				.createNamedQuery("fetch-all")
				.getResultList();
		
	}

	@Override
	public String findByEmailAndPassword(String email, String password) {
		return (String) entitymanager
				.createQuery("select f.fEmail from Farmer_Details f where f.fEmail = :em and f.fPassword = :pw ")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}

	@Override
	public boolean isFarmerPresent(String fEmail) {
		//System.out.println("end mai  "+fEmail);
		return (Long)
				entitymanager
				.createQuery("select count(f.fEmail) from Farmer_Details f where f.fEmail = :em ")
				.setParameter("em", fEmail)
				.getSingleResult() == 1 ? true : false;
	}
	
	@Override
	public Farmer_Details findById(String fEmail) {
		return entitymanager.find(Farmer_Details.class, fEmail);
	}

}
