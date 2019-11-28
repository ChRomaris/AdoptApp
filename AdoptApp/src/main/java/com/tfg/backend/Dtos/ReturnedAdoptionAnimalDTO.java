package com.tfg.backend.Dtos;

import java.util.Calendar;
import java.util.List;

import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.AdoptionAnimal.AdoptionState;
import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.AnimalGenre;
import com.tfg.backend.Entities.Animal.Size;
import com.tfg.backend.Entities.Breed;

public class ReturnedAdoptionAnimalDTO {
	private Long id;
	private String name;
	private AnimalGenre genre;
	private Breed breed;
	private String description;
	private Color color;
	private Size size;
	private  String image;
	private List<ImageDTO> images;
	private String imageDescription;
	private Calendar imageDateTime;
	private Calendar birthDate;
	private String health_comment;
	private Boolean trained;
	private AdoptionState state;
	private Long adoptionTime;
	private Long shelterId;
	private String shelterName;
	private Float latitude;
	private Float longitude;
	
	
	
	public ReturnedAdoptionAnimalDTO() {
	    super();
	}
	
	
	

	
	public String getShelterName() {
	    return shelterName;
	}





	public void setShelterName(String shelterName) {
	    this.shelterName = shelterName;
	}





	public List<ImageDTO> getImages() {
	    return images;
	}



	public void setImages(List<ImageDTO> images) {
	    this.images = images;
	}






	public Float getLatitude() {
	    return latitude;
	}




	public void setLatitude(Float latitude) {
	    this.latitude = latitude;
	}




	public Float getLongitude() {
	    return longitude;
	}




	public void setLongitude(Float longitude) {
	    this.longitude = longitude;
	}




	public Breed getBreed() {
	    return breed;
	}


	public void setBreed(Breed breed) {
	    this.breed = breed;
	}


	public Long getId() {
	    return id;
	}
	public void setId(Long id) {
	    this.id = id;
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
	public Calendar getBirthDate() {
	    return birthDate;
	}
	public void setBirthDate(Calendar birthDate) {
	    this.birthDate = birthDate;
	}
	public String getHealth_comment() {
	    return health_comment;
	}
	public void setHealth_comment(String health_comment) {
	    this.health_comment = health_comment;
	}
	public Boolean getTrained() {
	    return trained;
	}
	public void setTrained(Boolean trained) {
	    this.trained = trained;
	}
	public AdoptionState getState() {
	    return state;
	}

	public void setState(AdoptionState state) {
	    this.state = state;
	}

	public Long getAdoptionTime() {
	    return adoptionTime;
	}
	public void setAdoptionTime(Long adoptionTime) {
	    this.adoptionTime = adoptionTime;
	}
	public Long getShelterId() {
	    return shelterId;
	}
	public void setShelterId(Long shelterId) {
	    this.shelterId = shelterId;
	}
	
	
}
