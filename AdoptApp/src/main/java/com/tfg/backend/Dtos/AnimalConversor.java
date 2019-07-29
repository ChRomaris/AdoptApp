package com.tfg.backend.Dtos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Services.AnimalService;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AnimalConversor {
	
	private AnimalConversor() {
		
	}
	
	public final static AdoptionAnimal toAdoptionAnimal (AdoptionAnimalDTO animal ) throws IOException {
		
		AdoptionAnimal createdAnimal =  new AdoptionAnimal (animal.getName(),animal.getGenre(),animal.getDescription(), animal.getBirthDate(), animal.getHealth_comment(), animal.getColor(), animal.getSize(), animal.getTrained(),animal.getState(), animal.getAdoptionTime(), animal.getShelter());
		
		return createdAnimal;
	}
	
	public final static AdoptionAnimal toAdoptionAnimalEdit (AdoptionAnimalDTO animal ) throws IOException {
		
		AdoptionAnimal createdAnimal =  new AdoptionAnimal (animal.getId(), animal.getName(),animal.getGenre(),animal.getDescription(), animal.getBirthDate(), animal.getHealth_comment(), animal.getColor(), animal.getSize(), animal.getTrained(),animal.getState(), animal.getAdoptionTime(), animal.getShelter());
		
		return createdAnimal;
	}
	
	
	public final static AdoptionAnimalDTO toAdoptionAnimalDTO (AdoptionAnimal animal) {
		String image = null;
		
		if(animal.getImages()!=null && !animal.getImages().isEmpty()) {
			Set<AnimalPicture> images = animal.getImages();
			 image = images.iterator().next().getImage();
			
		}

		return new AdoptionAnimalDTO (animal.getName(),animal.getGenre(), animal.getDescription(), animal.getBirthDate(), animal.getHealth_comment(), animal.getColor(), animal.getSize(), animal.getTrained(), animal.getState(), animal.getAdoptionTime(), image);
	}
	
	public final static AdoptionAnimalDTO toAnimalDTO (Animal animal) {
		String image = null;
		
		if(animal.getImages()!=null && !animal.getImages().isEmpty()) {
			Set<AnimalPicture> images = animal.getImages();
			 image = images.iterator().next().getImage();
			
		}

		return new AdoptionAnimalDTO (animal.getId_animal(),animal.getName(),animal.getGenre(), animal.getDescription(), animal.getBirthDate(), animal.getHealth_comment(), animal.getColor(), animal.getSize(), animal.getTrained(), animal.getState(), image);
	}
	
	
	public final static List<AdoptionAnimalDTO> toAdoptionAnimalDTOList (List<AdoptionAnimal> adoptionAnimalList){
		List<AdoptionAnimalDTO> adoptionAnimalDTOList = new ArrayList<>();
		
		adoptionAnimalList.forEach((adoptionAnimal) -> adoptionAnimalDTOList.add(toAdoptionAnimalDTO(adoptionAnimal)));
		
		return adoptionAnimalDTOList;
	}
	
	public final static List<AdoptionAnimalDTO> toAnimalDTOList (List<Animal> adoptionAnimalList){
		List<AdoptionAnimalDTO> adoptionAnimalDTOList = new ArrayList<>();
		
		adoptionAnimalList.forEach((adoptionAnimal) -> adoptionAnimalDTOList.add(toAnimalDTO(adoptionAnimal)));
		
		return adoptionAnimalDTOList;
	}

}
