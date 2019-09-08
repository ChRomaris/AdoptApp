package com.tfg.backend.Daos;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.User;

public interface IProfileDao extends PagingAndSortingRepository<Profile, Long> {
    
    public Profile findByUsername (String username);
    public Optional<Profile> findById (Long id);
}
