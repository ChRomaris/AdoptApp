package com.tfg.backend.Dtos;

public class ShelterPreferencesDTO {
    private Long preferencesId;
    private Double maxAdoptionDistance;
    private Double maxLostDistance;
    private String userToken;
    
    public ShelterPreferencesDTO() {
	super();
    }

    public Long getPreferencesId() {
        return preferencesId;
    }

    public void setPreferencesId(Long preferencesId) {
        this.preferencesId = preferencesId;
    }

    public Double getMaxAdoptionDistance() {
        return maxAdoptionDistance;
    }

    public void setMaxAdoptionDistance(Double maxAdoptionDistance) {
        this.maxAdoptionDistance = maxAdoptionDistance;
    }

    public Double getMaxLostDistance() {
        return maxLostDistance;
    }

    public void setMaxLostDistance(Double maxLostDistance) {
        this.maxLostDistance = maxLostDistance;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
    
}
