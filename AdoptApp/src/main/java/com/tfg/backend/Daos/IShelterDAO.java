package com.tfg.backend.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.User;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Profile;

public interface IShelterDAO extends PagingAndSortingRepository<Shelter, Long> {
	public Shelter findByName (String name);
	
	@Query("Select s From Shelter s  WHERE (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance ")
	public List<Shelter> getSheltersInArea (Float longitude, Float latitude, Double maxDistance);
	
	
	@Query("Select (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001) From Shelter s  "+
	"WHERE (ST_Distance_Sphere(point(longitude, latitude), point(:longitude,:latitude )) * 0.001)<= :maxDistance ")
	public List<Double> getDistances(Float longitude, Float latitude, Double maxDistance);
}
