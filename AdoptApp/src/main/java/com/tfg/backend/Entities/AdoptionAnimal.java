package com.tfg.backend.Entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AdoptionAnimal extends Animal {
    @Column
    private Long adoptionTime;
    @Column
    private Calendar birthDate;
    @Column
    private String health_comment;
    @Column
    private Boolean trained;
    @Column
    private String state;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shelter", referencedColumnName = "id")
    private Shelter shelter;

    public AdoptionAnimal() {

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }
    
    

}
