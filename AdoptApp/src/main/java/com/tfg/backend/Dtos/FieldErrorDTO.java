package com.tfg.backend.Dtos;

public class FieldErrorDTO {
	
	private String fieldName;
	private String message;
	
	public FieldErrorDTO() {

	}

	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
