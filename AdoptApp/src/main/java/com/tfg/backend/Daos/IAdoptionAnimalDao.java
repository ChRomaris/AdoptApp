package com.tfg.backend.Daos;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Dtos.AnimalFilter;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal.AnimalGenre;
import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.Size;
import com.tfg.backend.Entities.AnimalType;
import com.tfg.backend.Entities.Breed;
import com.tfg.backend.Entities.Preferences;


public interface IAdoptionAnimalDao extends PagingAndSortingRepository<AdoptionAnimal, Long> {
    
    @Query("Select a From AdoptionAnimal a  WHERE ((ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance) and (:animalType is null or :animalType = a.breed.animalType) and (:breed is null or :breed = a.breed)and (:genre is null or :genre = a.genre)and (:color is null or :color = a.color)and (:size is null or :size = a.size) "+
	    "ORDER BY (ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001) ")
    List<AdoptionAnimal> searchAdoptionAnimalsByDistance(Float latitude, Float longitude, Double maxDistance,AnimalType animalType, Breed breed, AnimalGenre genre, Size size, Color color, Pageable pageRequest);
    
    
    @Query("Select (ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001) AS distance From AdoptionAnimal a  "+
	    "WHERE ((ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance) and (:animalType is null or :animalType = a.breed.animalType) and (:breed is null or :breed = a.breed) and (:genre is null or :genre = a.genre) and (:color is null or :color = a.color) and (:size is null or :size = a.size) ORDER BY distance ")
    List<Double> searchAdoptionAnimalsDistances(Float latitude, Float longitude, Double maxDistance,AnimalType animalType, Breed breed, AnimalGenre genre, Size size, Color color, Pageable pageRequest);
    
    @Query("Select Count (a)  From AdoptionAnimal a  "+
	    "WHERE ((ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance) and (:animalType is null or :animalType = a.breed.animalType) and (:breed is null or :breed = a.breed) and (:genre is null or :genre = a.genre) and (:color is null or :color = a.color) and (:size is null or :size = a.size) ")
    int countAdoptionAnimalsByDistance(Float latitude, Float longitude, Double maxDistance,AnimalType animalType, Breed breed, AnimalGenre genre, Size size, Color color);
    
    @Query("Select Count (a)  From AdoptionAnimal a WHERE (:animalType is null or :animalType = a.breed.animalType) and (:breed is null or :breed = a.breed) and (:genre is null or :genre = a.genre) and (:color is null or :color = a.color) and (:size is null or :size = a.size)")
    int countAdoptionAnimals(AnimalType animalType,Breed breed, AnimalGenre genre, Size size, Color color);
    
    @Query("Select a From AdoptionAnimal a Where a.shelter.id = :shelterId and (:breed is null or :breed = a.breed) and (:animalType is null or :animalType = a.breed.animalType) and (:genre is null or :genre = a.genre) and (:color is null or :color = a.color) and (:size is null or :size = a.size)")
    List<AdoptionAnimal> searchAdoptionAnimalsByShelter(Long shelterId,AnimalType animalType, Breed breed, AnimalGenre genre, Size size, Color color, Pageable pageRequest);
    
    @Query("Select Count(a) From AdoptionAnimal a Where a.shelter.id =:shelterId and (:breed is null or :breed = a.breed) and (:animalType is null or :animalType = a.breed.animalType) and (:genre is null or :genre = a.genre) and (:color is null or :color = a.color) and (:size is null or :size = a.size)")
    int countAdoptionAnimalsByShelter(Long shelterId,AnimalType animalType,Breed breed, AnimalGenre genre, Size size, Color color);
    
    @Query("Select a From AdoptionAnimal a Where ((a.breed = :breed or a.color = :color or a.size = :size) and (a.creationDate > :date) and ((ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance)) ")
    List<AdoptionAnimal> searchAnimalsByPreferences (Breed breed, Color color, Size size, Float latitude, Float longitude, Double maxDistance, Calendar date);
    
    @Query("Select a From AdoptionAnimal a  WHERE (:breed is null or :breed = a.breed) and (:animalType is null or :animalType = a.breed.animalType) and (:genre is null or :genre = a.genre) and (:color is null or :color = a.color) and (:size is null or :size = a.size)")
    List<AdoptionAnimal> searchAllAnimals(Breed breed,AnimalType animalType, AnimalGenre genre, Size size, Color color, Pageable pageRequest);
    
    
    
    
    
}
