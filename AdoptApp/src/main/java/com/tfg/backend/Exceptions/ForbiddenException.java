package com.tfg.backend.Exceptions;

public class ForbiddenException  extends Exception{
    	   public ForbiddenException() {
    	       
    	   }
    	   
	   public ForbiddenException(String errorMessage) {
	        super(errorMessage);
	    }
}
