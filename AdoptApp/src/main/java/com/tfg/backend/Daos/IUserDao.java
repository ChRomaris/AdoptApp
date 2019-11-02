package com.tfg.backend.Daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.User;
import com.tfg.backend.Entities.Animal.Breed;
import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.Genre;
import com.tfg.backend.Entities.Animal.Size;

import com.tfg.backend.Entities.Profile;

public interface IUserDao extends PagingAndSortingRepository<User, Long> {
	
	public Optional<User> findByUsername (String username);
	
	    @Query("Select u From User u where ((ST_Distance_Sphere(point(u.longitude, u.latitude), point(:longitude,:latitude )) * 0.001) < u.preferences.maxAdoptionDistance) and (:breed = u.preferences.breed or :color = u.preferences.color or :size = u.preferences.size or :genre = u.preferences.genre ) ")
	    public List<User> findByAnimalPreferences(Float latitude, Float longitude, Breed breed, Size size, Color color, Genre genre);

}
