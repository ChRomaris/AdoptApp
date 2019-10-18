package com.tfg.backend.Dtos;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import org.apache.tomcat.util.codec.binary.Base64;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.LostAnimal;
//import com.tfg.backend.Services.AnimalService;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Animal.Genre;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AnimalConversor {
    private AnimalConversor() {
    }
    
    public final static ImageDTO toImageDTO(AnimalPicture animalPicture) {
	ImageDTO imageDTO = new ImageDTO();
	imageDTO.setBase64(animalPicture.getImage());
	
	return imageDTO;
    }
    
    public final static List<ImageDTO> toImageDTOList (List<AnimalPicture> animalPictureList){
	
	List<ImageDTO> imageDTOList = new ArrayList<>();
	animalPictureList.forEach((animalPicture) -> {
	    imageDTOList.add(toImageDTO(animalPicture));
	});
	
	return imageDTOList;
    }
    
    public final static AdoptionAnimal toAdoptionAnimal(AnimalDTO animal) throws IOException {
	AdoptionAnimal adoptionAnimal = new AdoptionAnimal();
	adoptionAnimal.setColor(animal.getColor());
	adoptionAnimal.setDescription(animal.getDescription());
	adoptionAnimal.setGenre(animal.getGenre());
	adoptionAnimal.setBreed(animal.getBreed());
	if (animal.getId() != null)
	    adoptionAnimal.setId_animal(animal.getId());
	adoptionAnimal.setName(animal.getName());
	adoptionAnimal.setSize(animal.getSize());
	adoptionAnimal.setAdoptionTime(animal.getAdoptionAnimalInfoDTO().getAdoptionTime());
	adoptionAnimal.setBirthDate(animal.getAdoptionAnimalInfoDTO().getBirthDate());
	adoptionAnimal.setHealth_comment(animal.getAdoptionAnimalInfoDTO().getHealth_comment());
	adoptionAnimal.setShelter(animal.getAdoptionAnimalInfoDTO().getShelter());
	adoptionAnimal.setState(animal.getAdoptionAnimalInfoDTO().getState());
	adoptionAnimal.setTrained(animal.getAdoptionAnimalInfoDTO().getTrained());
	
	return adoptionAnimal;
    }

    public final static AnimalDTO toAnimalDTO(AdoptionAnimal animal) throws UnsupportedEncodingException {
	AnimalDTO animalDTO = new AnimalDTO();
	AdoptionAnimalInfoDTO adoptionAnimalInfoDTO = new AdoptionAnimalInfoDTO();
	String image = null;
	if (animal.getImages() != null && !animal.getImages().isEmpty()) {
	    Set<AnimalPicture> imageSet = animal.getImages();
	    image = imageSet.iterator().next().getImage();
	    List<AnimalPicture> imageList = new ArrayList<AnimalPicture>(imageSet);
	    animalDTO.setImages(toImageDTOList(imageList));
	}
	animalDTO.setColor(animal.getColor());
	animalDTO.setDescription(animal.getDescription());
	animalDTO.setGenre(animal.getGenre());
	animalDTO.setId(animal.getId_animal());
	animalDTO.setImage(image);
	animalDTO.setName(animal.getName());
	animalDTO.setSize(animal.getSize());
	adoptionAnimalInfoDTO.setAdoptionTime(animal.getAdoptionTime());
	adoptionAnimalInfoDTO.setBirthDate(animal.getBirthDate());
	adoptionAnimalInfoDTO.setHealth_comment(animal.getHealth_comment());
	adoptionAnimalInfoDTO.setShelter(animal.getShelter());
	adoptionAnimalInfoDTO.setState(animal.getState());
	adoptionAnimalInfoDTO.setTrained(animal.getTrained());
	animalDTO.setAdoptionAnimalInfoDTO(adoptionAnimalInfoDTO);
	return animalDTO;
    }
    
    public final static AnimalDTO toAnimalDTO(LostAnimal animal) {
	AnimalDTO animalDTO = new AnimalDTO();
	LostAnimalInfoDTO lostAnimalInfoDTO = new LostAnimalInfoDTO();
	String image = null;
	if (animal.getImages() != null && !animal.getImages().isEmpty()) {
	    Set<AnimalPicture> imageSet = animal.getImages();
	    image = imageSet.iterator().next().getImage();
	    List<AnimalPicture> imageList = new ArrayList<AnimalPicture>(imageSet);
	    animalDTO.setImages(toImageDTOList(imageList));
	}
	animalDTO.setColor(animal.getColor());
	animalDTO.setDescription(animal.getDescription());
	animalDTO.setGenre(animal.getGenre());
	animalDTO.setId(animal.getId_animal());
	animalDTO.setName(animal.getName());
	animalDTO.setSize(animal.getSize());
	lostAnimalInfoDTO.setBreed(animal.getBreed());
	lostAnimalInfoDTO.setComment(animal.getComment());
	lostAnimalInfoDTO.setDateTime(animal.getDateTime());
	lostAnimalInfoDTO.setLatitude(animal.getLatitude());
	lostAnimalInfoDTO.setLongitude(animal.getLongitude());
	lostAnimalInfoDTO.setState(animal.getState());
	animalDTO.setLostAnimalInfoDTO(lostAnimalInfoDTO);
	
	return animalDTO;
	
    }
    public final static ReturnedAdoptionAnimalDTO toReturnedAdoptionAnimalDTO(AnimalDTO animalDTO) {
	ReturnedAdoptionAnimalDTO returnedAdoptionAnimalDTO = new ReturnedAdoptionAnimalDTO();
	returnedAdoptionAnimalDTO.setId(animalDTO.getId());
	returnedAdoptionAnimalDTO.setName(animalDTO.getName());
	returnedAdoptionAnimalDTO.setGenre(animalDTO.getGenre());
	returnedAdoptionAnimalDTO.setDescription(animalDTO.getDescription());
	returnedAdoptionAnimalDTO.setColor(animalDTO.getColor());
	returnedAdoptionAnimalDTO.setSize(animalDTO.getSize());
	returnedAdoptionAnimalDTO.setImage(animalDTO.getImage());
	returnedAdoptionAnimalDTO.setImageDescription(animalDTO.getImageDescription());
	returnedAdoptionAnimalDTO.setImageDateTime(animalDTO.getImageDateTime());
	returnedAdoptionAnimalDTO.setBirthDate(animalDTO.getAdoptionAnimalInfoDTO().getBirthDate());
	returnedAdoptionAnimalDTO.setHealth_comment(animalDTO.getAdoptionAnimalInfoDTO().getHealth_comment());
	returnedAdoptionAnimalDTO.setTrained(animalDTO.getAdoptionAnimalInfoDTO().getTrained());
	returnedAdoptionAnimalDTO.setState(animalDTO.getAdoptionAnimalInfoDTO().getState());
	returnedAdoptionAnimalDTO.setAdoptionTime(animalDTO.getAdoptionAnimalInfoDTO().getAdoptionTime());
	returnedAdoptionAnimalDTO.setShelterId(animalDTO.getAdoptionAnimalInfoDTO().getShelter().getId());
	
	return returnedAdoptionAnimalDTO;
    }

    public final static ReturnedAdoptionAnimalDTO toReturnedAdoptionAnimalDTO(AdoptionAnimal adoptionAnimal) throws UnsupportedEncodingException {

	ReturnedAdoptionAnimalDTO returnedAdoptionAnimalDTO = new ReturnedAdoptionAnimalDTO();
	returnedAdoptionAnimalDTO.setId(adoptionAnimal.getId_animal());
	returnedAdoptionAnimalDTO.setName(adoptionAnimal.getName());
	returnedAdoptionAnimalDTO.setGenre(adoptionAnimal.getGenre());
	returnedAdoptionAnimalDTO.setBreed(adoptionAnimal.getBreed());
	returnedAdoptionAnimalDTO.setDescription(adoptionAnimal.getDescription());
	returnedAdoptionAnimalDTO.setColor(adoptionAnimal.getColor());
	returnedAdoptionAnimalDTO.setSize(adoptionAnimal.getSize());
	returnedAdoptionAnimalDTO.setBirthDate(adoptionAnimal.getBirthDate());
	returnedAdoptionAnimalDTO.setHealth_comment(adoptionAnimal.getHealth_comment());
	returnedAdoptionAnimalDTO.setTrained(adoptionAnimal.getTrained());
	returnedAdoptionAnimalDTO.setState(adoptionAnimal.getState());
	returnedAdoptionAnimalDTO.setAdoptionTime(adoptionAnimal.getAdoptionTime());
	returnedAdoptionAnimalDTO.setShelterId(adoptionAnimal.getShelter().getId());
	returnedAdoptionAnimalDTO.setLatitude(adoptionAnimal.getShelter().getLatitude());
	returnedAdoptionAnimalDTO.setLongitude(adoptionAnimal.getShelter().getLongitude());
	if(adoptionAnimal.getImages().iterator().hasNext()) {
	    Set<AnimalPicture> imageSet = adoptionAnimal.getImages();
	    returnedAdoptionAnimalDTO.setImage(adoptionAnimal.getImages().iterator().next().getImage());
	    List<AnimalPicture> imageList = new ArrayList<AnimalPicture>(imageSet);
	    returnedAdoptionAnimalDTO.setImages(toImageDTOList(imageList));
	}
	return returnedAdoptionAnimalDTO;
    }
    
    public final static List<AnimalDTO> toAnimalDTOList(List<AdoptionAnimal> adoptionAnimalList) {
	List<AnimalDTO> adoptionAnimalDTOList = new ArrayList<>();

	adoptionAnimalList.forEach((adoptionAnimal) -> {
	    try {
		adoptionAnimalDTOList.add(toAnimalDTO(adoptionAnimal));
	    } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	});

	return adoptionAnimalDTOList;
    }

    public final static List<ReturnedAdoptionAnimalDTO> toReturnedAdoptionAnimalDTOList(List<AdoptionAnimal> adoptionAnimalList) {
	List<ReturnedAdoptionAnimalDTO> returnedAdoptionAnimalDTO = new ArrayList<>();


	adoptionAnimalList.forEach((adoptionAnimal) -> {
	    try {
		returnedAdoptionAnimalDTO.add(toReturnedAdoptionAnimalDTO(adoptionAnimal));
	    } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	});

	return returnedAdoptionAnimalDTO;
    }

    public final static AnimalMarkerDTO toAnimalMarkerDTO (AdoptionAnimal animal) throws UnsupportedEncodingException {
	AnimalMarkerDTO marker = new AnimalMarkerDTO();
	marker.setId(animal.getId_animal());
	marker.setName(animal.getName());
	marker.setBreed(animal.getBreed());
	marker.setBirthDate(animal.getBirthDate());
	marker.setDescription(animal.getDescription());
	marker.setLatitude(animal.getShelter().getLatitude());
	marker.setLongitude(animal.getShelter().getLongitude());
	if(animal.getImages().iterator().hasNext()) {
	    marker.setImage(animal.getImages().iterator().next().getImage());
	}
	return marker;
	
    }
    
    public final static LostAnimal toLostAnimal (AnimalDTO animalDTO) {
	LostAnimal lostAnimal = new LostAnimal();
	lostAnimal.setBreed(animalDTO.getBreed());
	lostAnimal.setColor(animalDTO.getColor());
	if(animalDTO.getLostAnimalInfoDTO().getComment() != null)
	lostAnimal.setComment(animalDTO.getLostAnimalInfoDTO().getComment());
	lostAnimal.setDateTime(animalDTO.getLostAnimalInfoDTO().getDateTime());
	lostAnimal.setDescription(animalDTO.getDescription());
	lostAnimal.setGenre(animalDTO.getGenre());
	if(animalDTO.getId() != null)
	lostAnimal.setId_animal(animalDTO.getId());
	lostAnimal.setLatitude(animalDTO.getLostAnimalInfoDTO().getLatitude());
	lostAnimal.setLongitude(animalDTO.getLostAnimalInfoDTO().getLongitude());
	lostAnimal.setName(animalDTO.getName());
	lostAnimal.setSize(animalDTO.getSize());
	lostAnimal.setState(animalDTO.getLostAnimalInfoDTO().getState());
	
	return lostAnimal;
    }
    
    public final static LostAnimalInfoDTO toLostAnimalInfoDTO (LostAnimal lostAnimal) {
	LostAnimalInfoDTO lostAnimalInfoDTO = new LostAnimalInfoDTO();
	lostAnimalInfoDTO.setId(lostAnimal.getId_animal());
	lostAnimalInfoDTO.setName(lostAnimal.getName());
	lostAnimalInfoDTO.setBreed(lostAnimal.getBreed());
	lostAnimalInfoDTO.setUserName(lostAnimal.getOwner().getUsername());
	lostAnimalInfoDTO.setDateTime(lostAnimal.getDateTime());
	lostAnimalInfoDTO.setLatitude(lostAnimal.getLatitude());
	lostAnimalInfoDTO.setLongitude(lostAnimal.getLongitude());
	if(!lostAnimal.getImages().isEmpty()) {
	    Set<AnimalPicture> imageSet = lostAnimal.getImages();
	    lostAnimalInfoDTO.setImage(imageSet.iterator().next().getImage()); 
	    List<AnimalPicture> imageList = new ArrayList<AnimalPicture>(imageSet);
	    lostAnimalInfoDTO.setImages(toImageDTOList(imageList));
	}
	
	return lostAnimalInfoDTO;
    }
    
    public final static List<LostAnimalInfoDTO> toLostAnimalInfoDTOList (List<LostAnimal> lostAnimalList){
	List<LostAnimalInfoDTO> lostAnimalInfoDTOList = new ArrayList<>();
	lostAnimalList.forEach((lostAnimal) -> {
	    lostAnimalInfoDTOList.add(toLostAnimalInfoDTO(lostAnimal));
	});
	
	return lostAnimalInfoDTOList;
    }
    

    
    
    
}