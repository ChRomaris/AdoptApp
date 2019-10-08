package com.tfg.backend.Dtos;

import java.util.List;

public class LostAnimalPageDTO {

    private List <ReturnedLostAnimalDTO> lostAnimals;
    private int totalPages;


    public LostAnimalPageDTO() {
	super();
    }
    public List<ReturnedLostAnimalDTO> getLostAnimals() {
        return lostAnimals;
    }
    public void setLostAnimals(List<ReturnedLostAnimalDTO> lostAnimals) {
        this.lostAnimals = lostAnimals;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }




}