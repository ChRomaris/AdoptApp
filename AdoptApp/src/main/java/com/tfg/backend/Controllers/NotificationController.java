package com.tfg.backend.Controllers;

import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.Dtos.DeleteNotificationDTO;
import com.tfg.backend.Entities.Notification;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Services.INotificationService;

@RestController
@RequestMapping("/notification/")
public class NotificationController {
    
    @Autowired
    INotificationService notificationService;

    
    @GetMapping("/get")
    public List<Notification> getNotifications (@RequestParam String userToken){
	return notificationService.getNotifications(userToken);
    }
    
    @PostMapping("/delete")
    public List<Notification> deleteNotification (@RequestBody DeleteNotificationDTO deleteNotificationDTO) throws ForbiddenException, InstanceNotFoundException{
	return notificationService.deleteNotification(deleteNotificationDTO.getNotificationId(), deleteNotificationDTO.getUserToken());
    }
}
