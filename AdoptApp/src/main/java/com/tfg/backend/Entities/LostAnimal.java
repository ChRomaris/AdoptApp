package com.tfg.backend.Entities;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "LostAnimal")
public class LostAnimal extends Animal{
    
    public enum LostState {
	LOST, FOUND
    }
    
    @Column
    private Float latitude;
    
    @Column
    private Float longitude;
    
    @Column
    private LostState state;
    
    @Column
    private Calendar dateTime;
    
    @Column
    private String comment;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="ownerId", referencedColumnName = "id")
    private User owner;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Location> locations;
    
    public LostAnimal() {
	super();
    }
    
    
    public User getOwner() {
        return owner;
    }


    public void setOwner(User owner) {
        this.owner = owner;
    }


    public List<Location> getLocations() {
        return locations;
    }


    public void setLocations(List<Location> locations) {
        this.locations = locations;
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

    public LostState getState() {
        return state;
    }
    public void setState(LostState state) {
        this.state = state;
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
