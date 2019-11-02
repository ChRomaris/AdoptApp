package com.tfg.backend.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Chat")
@SequenceGenerator(name="CHAT_SEQ", sequenceName="chat_sequence")
@Inheritance(strategy = InheritanceType.JOINED)
public class Chat {
    
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CHAT_SEQ")
Long id;

@ManyToOne
@JoinColumn(name="senderId", referencedColumnName = "id")
Profile sender;

@ManyToOne
@JoinColumn(name="receiverId", referencedColumnName = "id")
Profile receiver;

@OneToMany(mappedBy="chat", cascade = CascadeType.ALL)
List<Message> messages;


public Chat() {
    super();
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}



public Profile getSender() {
    return sender;
}

public void setSender(Profile sender) {
    this.sender = sender;
}

public Profile getReceiver() {
    return receiver;
}

public void setReceiver(Profile receiver) {
    this.receiver = receiver;
}

public List<Message> getMessages() {
    return messages;
}

public void setMessages(List<Message> messages) {
    this.messages = messages;
}




}
