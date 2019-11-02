package com.tfg.backend.Entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Message")
@SequenceGenerator(name="MESSAGE_SEQ", sequenceName="message_sequence")
@Inheritance(strategy = InheritanceType.JOINED)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MESSAGE_SEQ")
    Long id;
    
    @Column
    String text;
    @Column
    Calendar dateTime;
    
    @Column
    boolean checked;
    
    @ManyToOne
    @JoinColumn(name="senderId", referencedColumnName = "id")
    Profile messageSender;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="chatId", referencedColumnName = "id")
    Chat chat;

    public Message() {
	super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Profile getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(Profile messageSender) {
        this.messageSender = messageSender;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
    
    
}
