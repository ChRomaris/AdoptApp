package com.tfg.backend.Daos;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Preferences;



    public interface IPreferencesDAO extends PagingAndSortingRepository<Preferences, Long> {
	
	   
	}


