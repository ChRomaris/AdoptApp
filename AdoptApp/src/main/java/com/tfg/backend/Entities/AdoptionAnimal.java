package com.tfg.backend.Entities;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AdoptionAnimal extends Animal {
    
    public static enum AdoptionState{
	EN_ADOPCION, ADOPTADO
    }
    
    @Column
    private Long adoptionTime;
    @Column
    private Calendar birthDate;
    @Column
    private String healthComment;
    @Column
    private Boolean trained;
    @Column
    private AdoptionState state;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shelter", referencedColumnName = "id")
    private Shelter shelter;
    @Column
    private Calendar creationDate;

    public AdoptionAnimal() {

    }
    
    public static List<AdoptionState> getAdoptionStates() {
	return Arrays.asList(AdoptionState.class.getEnumConstants());
    }
    
    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAdoptionTime() {
	return adoptionTime;
    }

    public void setAdoptionTime(Long adoptionTime) {
	this.adoptionTime = adoptionTime;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getHealthComment() {
        return healthComment;
    }

    public void setHealthComment(String health_comment) {
        this.healthComment = health_comment;
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

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }
    
    

}
