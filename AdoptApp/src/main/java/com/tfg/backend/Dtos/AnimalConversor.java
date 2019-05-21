package com.tfg.backend.Dtos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.AnimalPicture;
import java.util.Base64;

public class AnimalConversor {
	
	private AnimalConversor() {
		
	}
	
	public final static AdoptionAnimal toAdoptionAnimal (AdoptionAnimalDTO animal ) throws IOException {
		
		AdoptionAnimal createdAnimal =  new AdoptionAnimal (animal.getName(),animal.getGenre(),animal.getDescription(), animal.getBirthDate(), animal.getHealth_comment(), animal.getColor(), animal.getSize(), animal.getTrained(),animal.getState(), animal.getAdoptionTime());
		
		return createdAnimal;
	}
	
	public final static AdoptionAnimalDTO toAdoptionAnimalDTO (AdoptionAnimal animal) {
		return new AdoptionAnimalDTO (animal.getName(),animal.getGenre(), animal.getDescription(), animal.getBirthDate(), animal.getHealth_comment(), animal.getColor(), animal.getSize(), animal.getTrained(), animal.getState(), animal.getAdoptionTime());
	}

}
