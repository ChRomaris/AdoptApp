package com.tfg.backend.Entities;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="NOTIFICATION_SEQ", sequenceName="notification_sequence")
@Table (name ="notification") 
public class Notification {
    
    public static enum Type {
	ADOPTION_ADDED, LOST_ADDED
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="NOTIFICATION_SEQ")
    private Long id;
    
    @Column
    private Type type;
    
    @Column
    private Calendar date;
    
    @ManyToOne 
    @JoinColumn (name = "profileId")
    private Profile profile;
  
 
    @ManyToOne 
    @JoinColumn (name = "animalId")
    private Animal animal;

    public Notification() {
	super();
    }
    
    





    public Calendar getDate() {
        return date;
    }







    public void setDate(Calendar date) {
        this.date = date;
    }







    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
    
    

}
