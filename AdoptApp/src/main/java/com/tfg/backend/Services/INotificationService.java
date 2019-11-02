package com.tfg.backend.Services;

import java.util.List;

import javax.management.InstanceNotFoundException;

import com.tfg.backend.Entities.Notification;
import com.tfg.backend.Exceptions.ForbiddenException;

public interface INotificationService {

    List<Notification> getNotifications(String userToken);

    List<Notification> deleteNotification(Long notificationId, String userToken) throws ForbiddenException, InstanceNotFoundException;

}
