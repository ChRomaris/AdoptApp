package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.AnimalGenre;
import com.tfg.backend.Entities.Animal.Size;
import com.tfg.backend.Entities.Breed;

public class UserPreferencesDTO {

private Long preferencesId;
private Breed breed;
private String breedName;
private Color color;
private Size size;
private AnimalGenre genre;
private boolean summary;
private Double maxAdoptionDistance;
private Double maxLostDistance;
private String userToken;

public UserPreferencesDTO() {
    super();
}



public String getBreedName() {
    return breedName;
}



public void setBreedName(String breedName) {
    this.breedName = breedName;
}



public String getUserToken() {
    return userToken;
}



public void setUserToken(String userToken) {
    this.userToken = userToken;
}



public AnimalGenre getGenre() {
    return genre;
}



public void setGenre(AnimalGenre genre) {
    this.genre = genre;
}



public Long getPreferencesId() {
    return preferencesId;
}

public void setPreferencesId(Long preferencesId) {
    this.preferencesId = preferencesId;
}

public Breed getBreed() {
    return breed;
}

public void setBreed(Breed breed) {
    this.breed = breed;
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

public boolean isSummary() {
    return summary;
}

public void setSummary(boolean summary) {
    this.summary = summary;
}

public Double getMaxAdoptionDistance() {
    return maxAdoptionDistance;
}

public void setMaxAdoptionDistance(Double maxAdoptionDistance) {
    this.maxAdoptionDistance = maxAdoptionDistance;
}

public Double getMaxLostDistance() {
    return maxLostDistance;
}

public void setMaxLostDistance(Double maxLostDistance) {
    this.maxLostDistance = maxLostDistance;
}



}
