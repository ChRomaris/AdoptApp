package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Message;

public class ProfileChatReducedDTO {

   String username;
   Message lastMessage;
   
public ProfileChatReducedDTO() {
    super();
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public Message getLastMessage() {
    return lastMessage;
}

public void setLastMessage(Message lastMessage) {
    this.lastMessage = lastMessage;
}
}
