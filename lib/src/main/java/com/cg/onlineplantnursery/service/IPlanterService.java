package com.cg.onlineplantnursery.service;

import java.util.List;

import com.cg.onlineplantnursery.entity.Planter;

public interface IPlanterService {
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter);

	Planter deletePlanter(Planter planter);

	Planter viewPlanter(int planterId);

	Planter viewPlanter(String planterShape);

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(double minCost, double maxCost);
}
