package com.tfg.backend.Dtos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.AnimalGenre;
import com.tfg.backend.Entities.Animal.Size;
import com.tfg.backend.Entities.AnimalType;
import com.tfg.backend.Entities.Breed;


public class AnimalDTO {
	private Long id;
	private String name;
	private AnimalGenre genre;
	private Breed breed;
	private AnimalType animalType;
	private String breedName;
	private String animalTypeName;
	private String description;
	private Color color;
	private Size size;
	private String image;
	private List<ImageDTO> images;	
	private String imageDescription;
	private Calendar imageDateTime;
	private String userToken;
	private AdoptionAnimalInfoDTO adoptionAnimalInfoDTO;
	private LostAnimalInfoDTO lostAnimalInfoDTO;
	
	
	public AnimalDTO() {
		super();
	}
	
	
	

	
	









	public AnimalType getAnimalType() {
	    return animalType;
	}















	public void setAnimalType(AnimalType animalType) {
	    this.animalType = animalType;
	}















	public String getAnimalTypeName() {
	    return animalTypeName;
	}















	public void setAnimalTypeName(String animalTypeName) {
	    this.animalTypeName = animalTypeName;
	}















	public String getBreedName() {
	    return breedName;
	}







	public void setBreedName(String breedName) {
	    this.breedName = breedName;
	}







	public List<ImageDTO> getImages() {
	    return images;
	}





	public void setImages(List<ImageDTO> images) {
	    this.images = images;
	}





	public LostAnimalInfoDTO getLostAnimalInfoDTO() {
	    return lostAnimalInfoDTO;
	}




	public void setLostAnimalInfoDTO(LostAnimalInfoDTO lostAnimalInfoDTO) {
	    this.lostAnimalInfoDTO = lostAnimalInfoDTO;
	}




	public Breed getBreed() {
	    return breed;
	}



	public void setBreed(Breed breed) {
	    this.breed = breed;
	}



	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageDescription() {
		return imageDescription;
	}



	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}



	public Calendar getImageDateTime() {
		return imageDateTime;
	}



	public void setImageDateTime(Calendar imageDateTime) {
		this.imageDateTime = imageDateTime;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AnimalGenre getGenre() {
		return genre;
	}
	public void setGenre(AnimalGenre genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public AdoptionAnimalInfoDTO getAdoptionAnimalInfoDTO() {
	    return adoptionAnimalInfoDTO;
	}

	public void setAdoptionAnimalInfoDTO(AdoptionAnimalInfoDTO adoptionAnimalInfoDTO) {
	    this.adoptionAnimalInfoDTO = adoptionAnimalInfoDTO;
	}
	


}
