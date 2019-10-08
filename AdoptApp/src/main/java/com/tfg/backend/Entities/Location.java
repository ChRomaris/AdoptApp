package com.tfg.backend.Entities;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@SequenceGenerator(name="LOCATION_SEQ", sequenceName="location_sequence")
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="LOCATION_SEQ")
    private Long LocationId;

    @Column
    private String userName;
    
    @Column
    private Float latitude;
    
    @Column
    private Float longitude;
    
    @Column
    private Calendar dateTime;
    
    @Column
    private String comment;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="animalId", referencedColumnName = "id_animal")
    private LostAnimal animal;
    
    public Location() {
	super();
    }
    
    
    public Long getLocationId() {
        return LocationId;
    }
    public void setLocationId(Long locationId) {
        LocationId = locationId;
    }
    public LostAnimal getAnimal() {
        return animal;
    }
    public void setAnimal(LostAnimal animal) {
        this.animal = animal;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
    public Calendar getDateTime() {
        return dateTime;
    }
    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
   
    
}