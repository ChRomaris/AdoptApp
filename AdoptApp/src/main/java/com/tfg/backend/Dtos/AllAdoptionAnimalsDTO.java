package com.tfg.backend.Dtos;

import java.util.List;

public class AllAdoptionAnimalsDTO {
	
	private List<ReturnedAdoptionAnimalDTO> animales;

	public List<ReturnedAdoptionAnimalDTO> getAnimales() {
		return animales;
	}

	public void setAnimales(List<ReturnedAdoptionAnimalDTO> animales) {
		this.animales = animales;
	}
	

}
