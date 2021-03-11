package com.cg.onlineplantnursery.service;

import java.util.List;

import com.cg.onlineplantnursery.entity.Plant;
import com.cg.onlineplantnursery.repository.IPlantRepositoryImpl;

public class IPlantServiceImpl implements IPlantService{
	private IPlantRepositoryImpl plantrepo;
	@Override
	public Plant addPlant(Plant plant) {		
		return plantrepo.addPlant(plant);
	}

	@Override
	public Plant updatePlant(Plant plant) {		
		return plantrepo.updatePlant(plant);
	}

	@Override
	public Plant deletePlant(Plant plant) {
		
		return plantrepo.deletePlant(plant);
	}

	@Override
	public Plant viewPlant(int plantId) {		
		return plantrepo.viewPlant(plantId);
	}

	@Override
	public Plant viewPlant(String commonName) {		
		return plantrepo.viewPlant(commonName);
	}

	@Override
	public List<Plant> viewAllPlants() {		
		return plantrepo.viewAllPlants();
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) {		
		return plantrepo.viewAllPlants(typeOfPlant);
	}

}
