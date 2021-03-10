package com.cg.onlineplantnursery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.onlineplantnursery.entity.Seed;

public class ISeedRepositoryImpl implements ISeedRepository {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager em = factory.createEntityManager();
	
	@Override
	public Seed addSeed(Seed seed) {
		em.getTransaction().begin();
		em.persist(seed);
		em.getTransaction().commit();
		
		System.out.println("One seed added");
		em.close();
		factory.close();
		return seed;
	}

	@Override
	public Seed updateSeed(Seed seed) {
		
		int tempId = seed.getSeedId();
		Seed tempSeed = em.find(Seed.class, tempId);
		if(tempSeed != null) {
			em.getTransaction().begin();
			tempSeed.setCommonName(seed.getCommonName());
			tempSeed.setBloomTime(seed.getBloomTime());
			tempSeed.setWatering(seed.getWatering());
			tempSeed.setDifficultyLevel(seed.getDifficultyLevel());
			tempSeed.setTemparature(seed.getTemparature());
			tempSeed.setTypeOfSeeds(seed.getTypeOfSeeds());
			tempSeed.setSeedsDescription(seed.getSeedsDescription());
			tempSeed.setSeedsStock(seed.getSeedsStock());
			tempSeed.setSeedsCost(seed.getSeedsCost());
			tempSeed.setSeedsPerPacket(seed.getSeedsPerPacket());
			em.getTransaction().commit();
		}
		return tempSeed;
	}

	@Override
	public Seed deleteSeed(Seed seed) {
		
		em.getTransaction().begin();
		Seed seedToBeDeleted = em.merge(seed);
		em.remove(seedToBeDeleted);
		em.getTransaction().commit();		
		//System.out.println("seed deleted");		
		//em.close();
		//factory.close();
		return seed;
		
	}

	@Override
	public Seed viewSeed(int seedId) {	
		em.getTransaction().begin();
		Seed seed = em.find(Seed.class, seedId);
//		if(seed !=null) {
//			System.out.println(seed);
//			System.out.println("Checking by ID");
//		}
		//System.out.println(seed);
		return seed;
	}

	@Override
	public Seed viewSeed(String commonName) {
		String str = "SELECT seed from Seed seed where seed.commonName = :ptitle";
		TypedQuery<Seed> query = em.createQuery(str,Seed.class);
		query.setParameter("ptitle", commonName);
		Seed seed = query.getSingleResult();
		//System.out.println(seed);
		return seed;
	}

	@Override
	public List<Seed> viewAllSeeds() {
		String str = "select seed from Seed seed";
		TypedQuery<Seed> query = em.createQuery(str,Seed.class);
		List<Seed> seeds = query.getResultList();
//		for(Seed s:seeds) {
//			System.out.println(s);
//		}
		return seeds;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) {
		String str = "select seed from Seed seed where seed.typeOfSeeds =:type";
		TypedQuery<Seed> query = em.createQuery(str,Seed.class);
		query.setParameter("type", typeOfSeed);		
		List<Seed> seeds = query.getResultList();
//		for(Seed s:seeds) {
//			System.out.println(s);
//		}
		return seeds;
	}

}
