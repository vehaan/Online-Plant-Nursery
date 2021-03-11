package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.cg.onlineplantnursery.entity.Planter;
import com.cg.onlineplantnursery.repository.IPlanterRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
class PlanterSpec {
	
	
	IPlanterRepositoryImpl planterrep;
	
	private Planter planter; 
	private List<Planter> allPlanters;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing started...");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Testing completed!");
	}

	@BeforeEach
	void setUp() throws Exception {
		planter = new Planter(1,34.50f,500,2,"Red","Circle",300,2000);
		allPlanters = new ArrayList<>();
		allPlanters.add(planter);
		planterrep = new IPlanterRepositoryImpl();
		System.out.println("Testing next...");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Completed this test!");
	}
	
	@Order(1)
	@Test
	void addPlanterTest() {
		assertEquals(planter, planterrep.addPlanter(planter));
	}
	
	@Order(6)
	@Test
	void updatePlanterTest() {
		assertEquals("Rectangle", (planterrep.updatePlanter(planter)).getPlanterShape()); //Hard coded for now
	}
	
	@Order(7)
	@Test
	void deletePlanterTest() {
		assertEquals(planter, planterrep.deletePlanter(planter));
	}
	
	@Order(2)
	@Test
	void viewPlanterTest1() {
		assertEquals(planter.getPlanterId(), (planterrep.viewPlanter(planter.getPlanterId())).getPlanterId());
	}
	
	@Order(3)
	@Test
	void viewPlanterTest2() {
		assertEquals(planter.getPlanterId(), planterrep.viewPlanter(planter.getPlanterShape()).getPlanterId());
	}
	
	@Order(4)
	@Test
	void viewAllPlantersTest1() {
	assertEquals(1, planterrep.viewAllPlanters().size());
	}
	
	@Order(5)
	@Test
	void viewAllPlantersTest2() {
		double min = 1000, max = 2500;
		assertEquals(1,planterrep.viewAllPlanters(min, max).size());
	}
}
