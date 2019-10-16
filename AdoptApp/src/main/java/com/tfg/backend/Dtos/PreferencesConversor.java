package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Preferences;

public class PreferencesConversor {
    
    public final static UserPreferencesDTO toUserPreferencesDTO (Preferences preferences) {
	UserPreferencesDTO userPreferencesDTO = new UserPreferencesDTO ();
	userPreferencesDTO.setBreed(preferences.getBreed());
	userPreferencesDTO.setColor(preferences.getColor());
	userPreferencesDTO.setGenre(preferences.getGenre());
	userPreferencesDTO.setMaxAdoptionDistance(preferences.getMaxAdoptionDistance());
	userPreferencesDTO.setMaxLostDistance(preferences.getMaxLostDistance());
	userPreferencesDTO.setSize(preferences.getSize());
	userPreferencesDTO.setSummary(preferences.isSummary());
	userPreferencesDTO.setPreferencesId(preferences.getPreferencesId());
	
	return userPreferencesDTO;
    }
    
    public final static Preferences toPreferences (UserPreferencesDTO userPreferencesDTO) {
	Preferences preferences = new Preferences ();
	preferences.setBreed(userPreferencesDTO.getBreed());
	preferences.setColor(userPreferencesDTO.getColor());
	preferences.setGenre(userPreferencesDTO.getGenre());
	preferences.setMaxAdoptionDistance(userPreferencesDTO.getMaxAdoptionDistance());
	preferences.setMaxLostDistance(userPreferencesDTO.getMaxLostDistance());
	preferences.setSize(userPreferencesDTO.getSize());
	preferences.setSummary(userPreferencesDTO.isSummary());
	preferences.setPreferencesId(userPreferencesDTO.getPreferencesId());
	
	return preferences;
    }
    
    public final static Preferences toPreferences (ShelterPreferencesDTO shelterPreferencesDTO) {
	Preferences preferences = new Preferences ();
	preferences.setMaxAdoptionDistance(shelterPreferencesDTO.getMaxAdoptionDistance());
	preferences.setMaxLostDistance(shelterPreferencesDTO.getMaxLostDistance());
	preferences.setPreferencesId(shelterPreferencesDTO.getPreferencesId());
	
	return preferences;
    }
    
    public final static ShelterPreferencesDTO toShelterPreferencesDTO (Preferences preferences) {
	ShelterPreferencesDTO shelterPreferencesDTO = new ShelterPreferencesDTO ();
	shelterPreferencesDTO.setMaxAdoptionDistance(preferences.getMaxAdoptionDistance());
	shelterPreferencesDTO.setMaxLostDistance(preferences.getMaxLostDistance());
	shelterPreferencesDTO.setPreferencesId(preferences.getPreferencesId());
	
	return shelterPreferencesDTO;
    }
    
    

}
