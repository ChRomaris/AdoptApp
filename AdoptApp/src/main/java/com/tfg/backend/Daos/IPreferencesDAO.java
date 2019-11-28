package com.tfg.backend.Daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Preferences;



    public interface IPreferencesDAO extends PagingAndSortingRepository<Preferences, Long> {
	
	  List<Preferences> findBySummary(Boolean summary);
	}


