package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.cg.onlineplantnursery.entity.Plant;

import com.cg.onlineplantnursery.repository.IPlantRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class) 
class PlantSpec {
	
	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("demo1");
	EntityManager em  =  factory.createEntityManager();
	IPlantRepositoryImpl obj = new IPlantRepositoryImpl();
	
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
		Plant plant1 = new Plant(1,null,null,null,null,null,null,null,null,null,null,0.0);
		Plant plant2 = new Plant(2,1,"slow","Rose","winter","for beauty","hard","cold","herb","flowering-plant",5,7.0);
		Plant plant3 = new Plant(3,8,"fast","Lemon","summer","for lemons","easy","hot","shrub","fruit-plant",50,10.0);
		obj.addPlant(plant2);
		obj.addPlant(plant3);
		assertEquals(plant1,obj.addPlant(plant1));
	}
	@Test
	@Order(2)
	@DisplayName("checking if it prohibits adding same plant again")
	void testAddPlant2() {
		Plant plant2 = new Plant(2,1,"slow","Rose","winter","for beauty","hard","cold","herb","flowering-plant",5,7.0);
		assertNull(obj.addPlant(plant2));
	}
	
	
	
	
	//@Disabled
	@Test
	@Order(3)
	void testUpdatePlant() {
		Plant b = new Plant(1,3,"fast","Lotus","summer","for aroma","easy","warm","herb","flowering-Plant",22,50.0);
		Plant plant = obj.updatePlant(b);
		assertEquals("fast", plant.getPlantSpread());

	}
	//@Disabled
	@Test
	@Order(4)
	void deletePlant() {
		em.getTransaction().begin();
		Plant plantToBeDeleted = em.find(Plant.class,1);
		assertEquals(plantToBeDeleted.getPlantId(),obj.deletePlant(plantToBeDeleted).getPlantId());	
		em.close();
		factory.close();
	}
	
	//@Disabled
	@Order(5)
	@Test
	void testViewPlant() {
		assertEquals("Lemon",obj.viewPlant(3).getCommonName());
	}
	
	//@Disabled
	@Test
	@Order(6)
	void testViewPlant2() {
		assertEquals("Lemon",obj.viewPlant("Lemon").getCommonName());
	}
	
	//@Disabled
	@Order(7)
	@Test
	void testViewAllPlants() {
		assertEquals(2,obj.viewAllPlants().size());
	}
	//@Disabled
	@Order(8)
	@Test
	void testViewAllPlants2() {
		assertEquals(1,obj.viewAllPlants("herb").size());
	}

}
