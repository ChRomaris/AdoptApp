package com.tfg.backend.Entities;

public enum RoleType {
    USER("USER"),
    SHELTER("SHELTER") ;
    
    private String value;
    
    RoleType(String value){
	this.value = value;
    }
    
    public String value() {
	return value;
    }
    
}
