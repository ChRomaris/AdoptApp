package com.tfg.backend.Dtos;

public class StartChatDTO {
    
    private String userToken;
    private Long id;
    
    
    public String getUserToken() {
        return userToken;
    }
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
