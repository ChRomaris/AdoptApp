package com.tfg.backend.Services;

import com.tfg.backend.Dtos.LocationDTO;
import com.tfg.backend.Dtos.ReturnedLocationDTO;

public interface ILocationService {

    ReturnedLocationDTO addLocation(LocationDTO locationDTO);


}