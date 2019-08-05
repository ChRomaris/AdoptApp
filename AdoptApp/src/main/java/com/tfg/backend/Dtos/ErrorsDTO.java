package com.tfg.backend.Dtos;

import java.util.List;

public class ErrorsDTO {
	
	private String globalError;
	private List<FieldErrorDTO> fieldErrors;
	
	public ErrorsDTO(String globalError) {
		this.globalError = globalError;
	}
	
	public ErrorsDTO(List<FieldErrorDTO> fieldErrors) {

		this.fieldErrors = fieldErrors;
		
	}

	public String getGlobalError() {
		return globalError;
	}

	public void setGlobalError(String globalError) {
		this.globalError = globalError;
	}

	public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}
