package com.tfg.backend.Dtos;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tfg.backend.Entities.LostAnimal;

public class LostAnimalsPageDTO {
    
   public Page<LostAnimal> lostAnimals;
   public int actualPage;
   
   public LostAnimalsPageDTO() {
    super();
   }

   public Page<LostAnimal> getLostAnimals() {
       return lostAnimals;
   }
   public void setLostAnimals(Page<LostAnimal> lostAnimals) {
       this.lostAnimals = lostAnimals;
   }
   
   public int getActualPage() {
       return actualPage;
   }
public void setActualPage(int actualPage) {
    this.actualPage = actualPage;
}
   
   
   
   
   
}
