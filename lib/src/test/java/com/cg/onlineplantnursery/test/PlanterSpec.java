package com.cg.onlineplantnursery.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.onlineplantnursery.entity.Planter;
import com.cg.onlineplantnursery.repository.IPlanterRepositoryImpl;

class PlanterSpec {
	
	
	IPlanterRepositoryImpl planterrep;
	
	private Planter planter;
	private Planter planter1;
	private List<Planter> allPlanters;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		allPlanters = new ArrayList<>();
		allPlanters.add(planter);
		allPlanters.add(planter1);
		planter = new Planter(new Integer(1),34.50f,500,2,"Red","Circle",300,2000);
		planterrep = new IPlanterRepositoryImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void addPlanterTest() {
		assertEquals(planter, planterrep.addPlanter(planter));
	}
	
	@Test
	void updatePlanterTest() {
		assertEquals(planter, planterrep.updatePlanter(planter));
	}
	
	@Test
	void deletePlanterTest() {
		assertEquals(planter, planterrep.deletePlanter(planter));
	}
	
	@Test
	void viewPlanterTest1() {
		assertEquals(planter.getPlanterId(), planterrep.viewPlanter(planter.getPlanterId()));
	}
	
	@Test
	void viewPlanterTest2() {
		assertEquals(planter.getPlanterShape(), planterrep.viewPlanter(planter.getPlanterShape()));
	}
	
	@Test
	void viewAllPlantersTest1() {
	assertEquals(allPlanters.size(), planterrep.viewAllPlanters().size());
	}
	
	@Test
	void viewAllPlantersTest2() {
		double min = 1000, max = 2500;
		List<Planter> selectedPlanters = new ArrayList<>();
		for (int i=0;i<allPlanters.size();i++) {
			if (allPlanters.get(i).getPlanterCost() > min && allPlanters.get(i).getPlanterCost()<2500)
				selectedPlanters.add(allPlanters.get(i));
		}
		assertEquals(selectedPlanters,planterrep.viewAllPlanters(min, max));
	}
}
