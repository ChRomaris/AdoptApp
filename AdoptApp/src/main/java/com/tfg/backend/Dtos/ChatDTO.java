package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.Message;

public class ChatDTO {

    Long id;
    String userToken;
    String username;
    List<Message> messages;
    

    public ChatDTO() {
	super();
    }
    
    
    
   
    public List<Message> getMessages() {
        return messages;
    }




    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }




    public String getUserToken() {
        return userToken;
    }


    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }




    public String getUsername() {
        return username;
    }




    public void setUsername(String username) {
        this.username = username;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
