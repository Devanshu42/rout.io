package com.gladiator.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gladiator.entity.Bidder_Details;

@Repository
public class Bidder_Repository_Impl implements Bidder_Repository {

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	@Transactional
	public void save(Bidder_Details bdetails) {
		entitymanager.merge(bdetails);
		
	}

	@Override
	public List<Bidder_Details> findAll() {
		return entitymanager
				.createNamedQuery("fetch-all")
				.getResultList();
	}

	@Override
	public String findByEmailAndPassword(String email, String password) {
		System.out.println("email pas in finbyemail and pass  "+email+password);
		return (String) entitymanager
				.createQuery("select b.bEmail from Bidder_Details b where b.bEmail = :em and b.bPassword = :pw ")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}

	@Override
	public boolean isBidderPresent(String email) {
		return (Long)
				entitymanager
				.createQuery("select count(b.bEmail) from Bidder_Details b where b.bEmail = :em ")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	public Bidder_Details findById(String bEmail) {
		return entitymanager.find(Bidder_Details.class, bEmail);
		
	}

	
}
