package com.tfg.backend.Services;

import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Daos.INotificationDAO;
import com.tfg.backend.Entities.Notification;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Exceptions.ForbiddenException;

@Service
public class NotificationService implements INotificationService{

@Autowired
INotificationDAO notificationDAO;

@Autowired
IProfileService profileService;

@Override
public List<Notification> getNotifications (String userToken){
    Profile profile = profileService.getProfileFromToken(userToken);
    
    List<Notification> notifications = notificationDAO.findByProfileId(profile.getId());
    
    return notifications;
    }

@Override
public List<Notification> deleteNotification (Long notificationId, String userToken) throws ForbiddenException, InstanceNotFoundException{
    Profile profile = profileService.getProfileFromToken(userToken);
    Optional<Notification> optionalNotification = notificationDAO.findById(notificationId);
    Notification notification = null;
    
    if(optionalNotification.isPresent()) {
	notification = optionalNotification.get();
	if(notification.getProfile().getId() == profile.getId()) {
	  
	    notificationDAO.deleteById(notificationId);
	}else {
	    throw new ForbiddenException();
	}
    }else {
	throw new InstanceNotFoundException();
    }
    
 return getNotifications(userToken);
    
}
    
}
