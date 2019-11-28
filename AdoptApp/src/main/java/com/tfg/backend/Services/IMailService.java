package com.tfg.backend.Services;

import java.util.List;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.User;

public interface IMailService {


    void sendEmail(List<AdoptionAnimal> animals, User user);

    void sendSummaries();

}
