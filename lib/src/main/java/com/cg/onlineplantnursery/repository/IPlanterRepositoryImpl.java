package com.cg.onlineplantnursery.repository;

import java.util.List;

import javax.persistence.*;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

import com.cg.onlineplantnursery.entity.Planter;

public class IPlanterRepositoryImpl implements IPlanterRepository{
	
	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("OnlinePlanterNursery");
	EntityManager em  =  factory.createEntityManager();

	@Override
	public Planter addPlanter(Planter planter) {
		em.persist(planter);
		return planter;
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		Planter p = em.find(Planter.class, planter.getPlanterId());
		em.getTransaction().begin();
		p.setPlanterShape("Ractangle"); //Hard coded for now
		em.getTransaction().commit();
		return planter;
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		Planter p = em.find(Planter.class, planter.getPlanterId());
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		return planter;
	}

	@Override
	public Planter viewPlanter(int planterId) {
		
		return em.find(Planter.class, planterId);
	}

	@Override
	public Planter viewPlanter(String planterShape) {
		Query query = em.createQuery("select p from Planter p where p.planterShape = planterShape");
		List<Planter> planters = query.getResultList();
		if (planters.size() != 0)
			return planters.get(0);
		return null;
	}

	@Override
	public List<Planter> viewAllPlanters() {
		Query query  = em.createQuery("Select p from Planter p");
		List<Planter> planters;
		planters = query.getResultList();
		return planters;
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {
		Query query = em.createQuery("select p from Planter p where p.planterCost between minCost and maxCost");
		List<Planter> selectedPlanters;
		selectedPlanters = query.getResultList();
		return selectedPlanters;
	}

}
