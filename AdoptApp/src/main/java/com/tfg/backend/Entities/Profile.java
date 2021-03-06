package com.tfg.backend.Entities;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tfg.backend.Entities.Animal.Genre;

import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Profile")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Profile {

    public static enum Genre {
	MALE, FEMALE
    }

    public static enum Type {
	PUBLIC, PRIVATE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Float latitude;
    @Column
    private Float longitude;
    @Column
    private RoleType role;
    @OneToOne(mappedBy = "profile")
    private Preferences preferences;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Chat> senderChats;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Chat> receiverChats;

    @OneToMany(mappedBy = "messageSender", cascade = CascadeType.ALL)
    private List<Message> messages;

    public Profile() {
	super();
    }

    public static List<Genre> getGenres() {
	return Arrays.asList(Genre.class.getEnumConstants());
    }

    public static List<Type> getTypes() {
	return Arrays.asList(Type.class.getEnumConstants());
    }

    public Preferences getPreferences() {
	return preferences;
    }

    public void setPreferences(Preferences preferences) {
	this.preferences = preferences;
    }

    public RoleType getRole() {
	return role;
    }

    public void setRole(RoleType role) {
	this.role = role;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

}