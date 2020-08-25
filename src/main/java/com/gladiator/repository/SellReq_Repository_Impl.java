package com.gladiator.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gladiator.entity.CropSell;

@Repository
public class SellReq_Repository_Impl implements SellReq_Repository{
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	@Transactional
	public void save(CropSell cropsell) {
		entitymanager.merge(cropsell);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CropSell> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
