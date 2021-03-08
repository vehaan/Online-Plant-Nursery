package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.cg.onlineplantnursery.entity.Plant;

import com.cg.onlineplantnursery.repository.IPlantRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class) 
class PlantSpec {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	//@Disabled
	@Test
	@Order(1)
	void testAddPlant() {
		//Plant a = null;
		//Plant a = new Plant(1,null,null,null,null,null,null,null,null,null,null,0.0);
		//Plant b = new Plant(2,1,"slow","Rose","winter","for beauty","hard","cold","herb","flowering-plant",5,7.0);
		Plant c = new Plant(3,8,"fast","Lemon","summer","for lemons","easy","hot","shrub","fruit-plant",50,10.0);
		IPlantRepositoryImpl obj = new IPlantRepositoryImpl();
		Plant plant = obj.addPlant(c);
		assertNotNull(plant.getCommonName());

		//fail("Not yet implemented");
	}
	
	@Disabled
	@Test
	@Order(2)
	void testUpdatePlant() {
		Plant b = new Plant(1,3,"fast","Lotus","summer","for aroma","easy","warm","herb","flowering-Plant",22,50.0);
		IPlantRepositoryImpl obj = new IPlantRepositoryImpl();
		Plant plant = obj.updatePlant(b);
		assertEquals("fast", plant.getPlantSpread());

	}
	@Disabled
	@Test
	@Order(3)
	void deletePlant() {
		IPlantRepositoryImpl obj = new IPlantRepositoryImpl();
		
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("demo1");
		EntityManager em  =  factory.createEntityManager();
		em.getTransaction().begin();

		Plant plantToBeDeleted = em.find(Plant.class,1);
		

		Plant deletedPlant = obj.deletePlant(plantToBeDeleted);
		System.out.println(deletedPlant);
		assertNull(deletedPlant);
		em.close();
		factory.close();
		
	}
	@Disabled
	@Order(3)
	@Test
	void testViewPlant() {
		IPlantRepositoryImpl obj = new IPlantRepositoryImpl();
		obj.viewPlant(1);
	}
	@Disabled
	@Test
	@Order(2)
	void testViewPlant2() {
		IPlantRepositoryImpl obj = new IPlantRepositoryImpl();
		obj.viewPlant("Lotus");
	}
	@Order(2)
	@Test
	void testViewAllPlants() {
		IPlantRepositoryImpl obj = new IPlantRepositoryImpl();
		obj.viewAllPlants();
	}
	@Order(3)
	@Test
	void testViewAllPlants2() {
		IPlantRepositoryImpl obj = new IPlantRepositoryImpl();
		obj.viewAllPlants("shrub");
	}

}
