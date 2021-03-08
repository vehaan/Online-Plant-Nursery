package com.cg.onlineplantnursery.repository;

import java.util.List;

import javax.persistence.*;

import com.cg.onlineplantnursery.entity.Plant;

public class IPlantRepositoryImpl implements IPlantRepository {
	
	
	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("demo1");
	EntityManager em  =  factory.createEntityManager();
	
	@Override
	public Plant addPlant(Plant plant) {

		em.getTransaction().begin();
		//Plant plant1 = new Plant();
		//plant1.setPlantId(1);
		//plant1.setCommonName("Lotus");
		
		em.persist(plant);
		em.getTransaction().commit();
		
		System.out.println("Added one plant to database.");
		em.close();
		factory.close();
		return plant;
		
	}

	@Override
	public Plant updatePlant(Plant plant) {
		int tempId = plant.getPlantId();
		Plant tempPlant = em.find(Plant.class, tempId);
		if(tempPlant != null) {
			em.getTransaction().begin();
			tempPlant.setPlantHeight(plant.getPlantHeight());
			tempPlant.setPlantSpread(plant.getPlantSpread());
			tempPlant.setCommonName(plant.getCommonName());
			tempPlant.setBloomTime(plant.getBloomTime());
			tempPlant.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
			tempPlant.setDifficultyLevel(plant.getDifficultyLevel());
			tempPlant.setTemparature(plant.getTemparature());
			tempPlant.setTypeOfPlant(plant.getTypeOfPlant());
			tempPlant.setPlantDescription(plant.getPlantDescription());
			tempPlant.setPlantCost(plant.getPlantCost());
			tempPlant.setPlantsStock(plant.getPlantsStock());
			em.getTransaction().commit();
			
		}
		return tempPlant;
	}

	@Override
	public Plant deletePlant(Plant plant) {
		em.getTransaction().begin();
		Plant plantToBeDeleted = em.merge(plant);
		em.remove(plantToBeDeleted);
		em.getTransaction().commit();
		return plantToBeDeleted;
		//em.close();
		//factory.close();
		
	}

	@Override
	public Plant viewPlant(int plantId) {
		em.getTransaction().begin();
		Plant tempPlant = em.find(Plant.class, plantId);
		if(tempPlant != null) {
			System.out.println(tempPlant);
			System.out.println("just to check");
		}
		System.out.println(tempPlant);
		System.out.println("just to check");
		return null;
	}

	@Override
	public Plant viewPlant(String commonName) {
		String qStr = "SELECT plant FROM Plant plant WHERE plant.commonName =:ptitle";
		TypedQuery<Plant> query =em.createQuery(qStr,Plant.class);
		query.setParameter("ptitle", commonName);
		Plant plant = query.getSingleResult();
		System.out.println(plant);
		
		return null;
	}

	@Override
	public List<Plant> viewAllPlants() {
		String qStr = "select plant from Plant plant";
		TypedQuery<Plant> query = em.createQuery(qStr, Plant.class);
		List<Plant> plants = query.getResultList();
		for(Plant x: plants) {
			System.out.println(x);
		}
		return null;
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) {
		String qStr = "select plant from Plant plant where plant.typeOfPlant = :type";
		TypedQuery<Plant> query = em.createQuery(qStr, Plant.class);
		query.setParameter("type", typeOfPlant);
		
		List<Plant> plants = query.getResultList();
		for(Plant x: plants) {
			System.out.println(x);
		}
		return null;
	}
}
