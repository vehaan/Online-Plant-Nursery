package com.cg.onlineplantnursery.repository;

import java.util.List;

import com.cg.onlineplantnursery.entity.Planter;

public interface IPlanterRepository {
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter);

	Planter deletePlanter(Planter planter);

	Planter viewPlanter(int planterId);

	Planter viewPlanter(String planterShape);

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(double minCost, double maxCost);
}
