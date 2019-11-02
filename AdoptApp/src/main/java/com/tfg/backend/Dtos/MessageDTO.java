package com.tfg.backend.Dtos;

import java.util.Calendar;

import com.tfg.backend.Entities.Chat;
import com.tfg.backend.Entities.Profile;

public class MessageDTO {
    private Long id;
    private Calendar DateTime;
    private String userToken;
    private String username;
    private Long chatId;
    private String text;
    private String author;
    private Long authorId;
    private String message;
    
    public MessageDTO() {
	super();
    }
    
    

    
    public String getAuthor() {
        return author;
    }




    public void setAuthor(String author) {
        this.author = author;
    }




    public Long getAuthorId() {
        return authorId;
    }




    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }




    public String getMessage() {
        return message;
    }




    public void setMessage(String message) {
        this.message = message;
    }




    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDateTime() {
        return DateTime;
    }

    public void setDateTime(Calendar dateTime) {
        DateTime = dateTime;
    }


    public Long getChatId() {
        return chatId;
    }


    public void setChatId(Long chatId) {
        this.chatId = chatId;
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
    
    
    
    
}
