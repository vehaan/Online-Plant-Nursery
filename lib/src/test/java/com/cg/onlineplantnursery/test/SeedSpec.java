package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
		//Seed seedTemp = new Seed(13,"Soya","2 days","normal","Medium","25 degree celcius","Vegetable","For Lemon",10,2,10);
		Seed seedTemp = new Seed(14,"Rose","5 days","Easy","Medium","20 degree celcius","Flower","For Rose",5,2,4);
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
	Seed seedTemp = new Seed(13,"Soya","2 days","normal","Medium","25 degree celcius","Vegetable","For Lemon",10,2,10);
	Seed seedToBeDeleted = em.find(Seed.class,seedTemp.getSeedId());
	
	Seed deletedSeed = obj.deleteSeed(seedToBeDeleted);
	System.out.println(deletedSeed);
	assertNotNull(deletedSeed);
	em.close();
	factory.close();
	}
	
	@Disabled
	@Order(3)
	@Test
	void testViewSeed() {
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		Seed seedActual = new Seed(12,"Apple","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,2,10);
		Seed seedExp = obj.viewSeed(12);
		assertEquals(seedActual.getCommonName(),seedExp.getCommonName());
	}
	
	@Disabled
	@Order(2)
	@Test
	void testViewSeed2() {
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		Seed seedActual = new Seed(12,"Apple","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,2,10);
		Seed seedExp = obj.viewSeed("Apple");
		assertEquals(seedActual.getCommonName(),seedExp.getCommonName());

	}
	
	@Disabled
	@Order(2)
	@Test
	void testViewAllSeeds() {
		
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		//ArrayList<Seed> seedListActual = new ArrayList<Seed>();
		ArrayList<Seed> seedListExp = new ArrayList<Seed>();
		
		//seedListActual = (ArrayList<Seed>) obj.viewAllSeeds();
		//seedListActual.add(new Seed(12,"Apple","2 days","normal","Easy","25 degree celcius","Vegetable","For Lemon",20,2,10));
		//seedListActual.add(new Seed(13,"Soya","2 days","normal","Medium","25 degree celcius","Vegetable","For Lemon",10,2,10));
		
		seedListExp = (ArrayList<Seed>) obj.viewAllSeeds();
		assertEquals(2,seedListExp.size());
		
	}
	
	@Disabled
	@Order(3)
	@Test
	void testViewAllPlants2() {
		ISeedRepositoryImpl obj = new ISeedRepositoryImpl();
		ArrayList<Seed> seedListExp = new ArrayList<Seed>();
		seedListExp = (ArrayList<Seed>) obj.viewAllSeeds("Vegetable");
		assertEquals(2,seedListExp.size());
	}
}

