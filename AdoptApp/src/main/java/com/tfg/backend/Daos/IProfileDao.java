package com.tfg.backend.Daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal.Breed;
import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.Size;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.Profile.Genre;
import com.tfg.backend.Entities.User;

public interface IProfileDao extends PagingAndSortingRepository<Profile, Long> {
    
    public Profile findByUsername (String username);
    public Optional<Profile> findById (Long id);
    
    
    @Query("Select p From Profile p where (ST_Distance_Sphere(point(p.longitude, p.latitude), point(:longitude,:latitude )) * 0.001) < p.preferences.maxLostDistance")
    public List<Profile> findByLostPreferences(Float latitude, Float longitude);
    

}
