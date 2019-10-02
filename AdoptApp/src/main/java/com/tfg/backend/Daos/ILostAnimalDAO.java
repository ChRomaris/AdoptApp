package com.tfg.backend.Daos;


import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.LostAnimal;

public interface ILostAnimalDAO extends PagingAndSortingRepository<LostAnimal, Long> {
    @Query("Select a From LostAnimal a  WHERE (6371 * acos (cos ( radians(:latitude) )* cos( radians( latitude ) )* cos( radians( longitude ) - radians(:longitude) )+ sin ( radians(:latitude) )* sin( radians( latitude ) )))< :maxDistance ORDER BY (6371 * acos (cos ( radians(:latitude) )* cos( radians( latitude ) )* cos( radians( longitude ) - radians(:longitude) )+ sin ( radians(:latitude) )* sin( radians( latitude ) ))) ")
    List<LostAnimal> searchLostAnimalsByDistance(Float latitude, Float longitude, Double maxDistance, Pageable pageRequest);
    @Query("Select (6371 * acos (cos ( radians(:latitude) )* cos( radians( latitude ) )* cos( radians( longitude ) - radians(:longitude) )+ sin ( radians(:latitude) )* sin( radians( latitude ) ))) AS distance From LostAnimal a  "+
	    "WHERE (6371 * acos (cos ( radians(:latitude) )* cos( radians( latitude ) )* cos( radians( longitude ) - radians(:longitude) )+ sin ( radians(:latitude) )* sin( radians( latitude ) )))< :maxDistance ORDER BY distance ")
    List<Double> searchLostAnimalsDistances(Float latitude, Float longitude, Double maxDistance, Pageable pageRequest);
    
    @Query("Select Count (a)  From LostAnimal a  "+
	    "WHERE (6371 * acos (cos ( radians(:latitude) )* cos( radians( latitude ) )* cos( radians( longitude ) - radians(:longitude) )+ sin ( radians(:latitude) )* sin( radians( latitude ) )))< :maxDistance ")
    int countLostAnimals(Float latitude, Float longitude, Double maxDistance);
    
}
	