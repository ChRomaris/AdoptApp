package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.RoleType;

public class ProfileDTO {
    private Long id;
    private String username;
    private String password;
    private Float latitude;
    private Float longitude;
    private String token;
    private RoleType role;
    private ShelterDTO shelterDTO;
    private UserDTO userDTO;
    
   
    public String getUsername() {
        return username;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long long1) {
        this.id = long1;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public ShelterDTO getShelterDTO() {
        return shelterDTO;
    }

    public void setShelterDTO(ShelterDTO shelterDTO) {
        this.shelterDTO = shelterDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    
   
    
       

}
