package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.cg.onlineplantnursery.entity.Seed;
import com.cg.onlineplantnursery.repository.ISeedRepositoryImpl;

class SeedSpec {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Disabled
	@Test
	@Order(1)
	void testAddSeed() {
		//Seed seedTemp = new Seed(12,"Lemon","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,2,10);
		Seed seedTemp = new Seed(13,"Soya","2 days","normal","Medium","25 degree celcius","Vegetable","For Lemon",10,2,10);
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		Seed seed1 = obj.addSeed(seedTemp);
		assertNotNull(seed1.getCommonName());
	}
	
	@Disabled
	@Test
	@Order(2)
	void testUpdatePlant() {
		Seed s = new Seed(12,"Apple","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,2,10);
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		Seed seed = obj.updateSeed(s);
		assertEquals("Apple", seed.getCommonName());
		
	}
	
	@Disabled
	@Test
	@Order(3)
	void testDeletePlant() {
	ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
	
	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("test1");
	EntityManager em  =  factory.createEntityManager();
	em.getTransaction().begin();

	Seed seedToBeDeleted = em.find(Seed.class,1);
	

	Seed deletedSeed = obj.deleteSeed(seedToBeDeleted);
	System.out.println(deletedSeed);
	assertNull(deletedSeed);
	em.close();
	factory.close();
	}
	
	@Disabled
	@Order(3)
	@Test
	void testViewSeed() {
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		obj.viewSeed(12);
	}
	
	@Disabled
	@Order(2)
	@Test
	void testViewSeed2() {
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		obj.viewSeed("Apple");
	}
	
	@Order(2)
	@Test
	void testViewAllSeeds() {
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		obj.viewAllSeeds();
	}
	
	@Order(3)
	@Test
	void testViewAllPlants2() {
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		obj.viewAllSeeds("shrub");
	}
}

