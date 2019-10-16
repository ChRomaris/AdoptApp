package com.tfg.backend.Daos;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Entities.User;

import org.springframework.data.repository.PagingAndSortingRepository;
public interface ILostAnimalDAO extends PagingAndSortingRepository<LostAnimal, Long> {
    @Query("Select a From LostAnimal a  WHERE (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance "+
	    "ORDER BY (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001) ")
    List<LostAnimal> searchLostAnimalsByDistance(Float latitude, Float longitude, Double maxDistance, Pageable pageRequest);
    
    @Query("Select a From LostAnimal a  WHERE (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance ")
    List<LostAnimal> searchLostAnimalsInArea(Float latitude, Float longitude, Double maxDistance);

    @Query("Select (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001) AS distance From LostAnimal a  "+
	    "WHERE (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance ORDER BY distance ")
    List<Double> searchLostAnimalsDistances(Float latitude, Float longitude, Double maxDistance, Pageable pageRequest);
    
    @Query("Select Count (a)  From LostAnimal a  "+
	    "WHERE (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance ")
    int countLostAnimals(Float latitude, Float longitude, Double maxDistance);
    
    List<LostAnimal> findByOwner (User user, Pageable pageRequest);
    
}