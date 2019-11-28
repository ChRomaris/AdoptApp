package com.tfg.backend.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.AnimalGenre;
import com.tfg.backend.Entities.Animal.Size;

@Entity
@Table(name = "Preferences")
@SequenceGenerator(name="PREFERENCES_SEQ", sequenceName="preferences_sequence")
@Inheritance(strategy = InheritanceType.JOINED)
public class Preferences {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PREFERENCES_SEQ")
private Long preferencesId;

@Column
private Color color;
@Column
private Size size;
@Column
private AnimalGenre genre;
@Column
private Boolean summary;
@Column
private Double maxAdoptionDistance;
@Column
private Double maxLostDistance;
@OneToOne
@JsonIgnore
@JoinColumn(name= "ProfileId", referencedColumnName = "id")
private Profile profile;

@ManyToOne
@JoinColumn(name="breedId", referencedColumnName = "breedId")
private Breed breed;

public Preferences() {
    super();
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





public AnimalGenre getGenre() {
    return genre;
}





public void setGenre(AnimalGenre genre) {
    this.genre = genre;
}





public Boolean isSummary() {
    return summary;
}





public void setSummary(Boolean summary) {
    this.summary = summary;
}





public Profile getProfile() {
    return profile;
}



public void setProfile(Profile profile) {
    this.profile = profile;
}



public Long getPreferencesId() {
    return preferencesId;
}

public void setPreferencesId(Long preferencesId) {
    this.preferencesId = preferencesId;
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
