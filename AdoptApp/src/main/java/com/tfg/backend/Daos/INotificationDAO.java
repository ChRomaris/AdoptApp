package com.tfg.backend.Daos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Message;
import com.tfg.backend.Entities.Notification;

public interface INotificationDAO extends PagingAndSortingRepository<Notification, Long>  {
    
    public List<Notification> findByProfileId(Long profileId);

}
