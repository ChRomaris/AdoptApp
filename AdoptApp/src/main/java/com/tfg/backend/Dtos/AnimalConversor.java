package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.AdoptionAnimal;

public class AnimalConversor {
	
	private AnimalConversor() {
		
	}
	
	public final static AdoptionAnimal toAdoptionAnimal (AdoptionAnimalDTO animal ) {
		return new AdoptionAnimal (animal.getName(),animal.getGenre(),animal.getDescription(), animal.getBirthDate(), animal.getHealth_comment(), animal.getColor(), animal.getSize(), animal.getTrained(),animal.getState(), animal.getAdoptionTime());
	}
	
	public final static AdoptionAnimalDTO toAdoptionAnimalDTO (AdoptionAnimal animal) {
		return new AdoptionAnimalDTO (animal.getName(),animal.getGenre(), animal.getDescription(), animal.getBirthDate(), animal.getHealth_comment(), animal.getColor(), animal.getSize(), animal.getTrained(), animal.getState(), animal.getAdoptionTime());
	}

}
