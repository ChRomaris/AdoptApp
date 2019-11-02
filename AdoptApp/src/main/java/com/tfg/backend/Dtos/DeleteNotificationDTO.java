package com.tfg.backend.Dtos;

public class DeleteNotificationDTO {

    private String userToken;
    private Long notificationId;
    
    public DeleteNotificationDTO() {
	super();
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }
   
  
    
}
