package com.tfg.backend.Dtos;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tfg.backend.Entities.AdoptionAnimal;

public class AdoptionAnimalsPageDTO {
public List<ReducedAdoptionAnimalDTO> adoptionAnimals;
public int totalPages;

public AdoptionAnimalsPageDTO() {
    super();
}

public List<ReducedAdoptionAnimalDTO> getAdoptionAnimals() {
    return adoptionAnimals;
}

public void setAdoptionAnimals(List<ReducedAdoptionAnimalDTO> adoptionAnimals) {
    this.adoptionAnimals = adoptionAnimals;
}

public int getTotalPages() {
    return totalPages;
}

public void setTotalPages(int actualPage) {
    this.totalPages = actualPage;
}
}
