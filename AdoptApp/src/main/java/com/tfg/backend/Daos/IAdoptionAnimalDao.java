package com.tfg.backend.Daos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.AdoptionAnimal;


public interface IAdoptionAnimalDao extends PagingAndSortingRepository<AdoptionAnimal, Long> {
    
    @Query("Select a From AdoptionAnimal a  WHERE (ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance "+
	    "ORDER BY (ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001) ")
    List<AdoptionAnimal> searchAdoptionAnimalsByDistance(Float latitude, Float longitude, Double maxDistance, Pageable pageRequest);
    
    @Query("Select (ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001) AS distance From AdoptionAnimal a  "+
	    "WHERE (ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance ORDER BY distance ")
    List<Double> searchAdoptionAnimalsDistances(Float latitude, Float longitude, Double maxDistance, Pageable pageRequest);
    
    @Query("Select Count (a)  From AdoptionAnimal a  "+
	    "WHERE (ST_Distance_Sphere(point(a.shelter.longitude, a.shelter.latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance ")
    int countAdoptionAnimalsByDistance(Float latitude, Float longitude, Double maxDistance);
    
    @Query("Select Count (a)  From AdoptionAnimal a")
    int countAdoptionAnimals();
    
    @Query("Select a From AdoptionAnimal a Where a.shelter.id = :shelterId")
    List<AdoptionAnimal> searchAdoptionAnimalsByShelter(Long shelterId, Pageable pageRequest);
    
    @Query("Select Count(a) From AdoptionAnimal a Where a.shelter.id =:shelterId")
    int countAdoptionAnimalsByShelter(Long shelterId);
    
    
}
