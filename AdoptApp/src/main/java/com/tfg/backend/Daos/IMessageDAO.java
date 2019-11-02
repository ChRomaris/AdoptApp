package com.tfg.backend.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Chat;
import com.tfg.backend.Entities.Message;

public interface IMessageDAO extends PagingAndSortingRepository<Message, Long>  {

    
    @Query("Select m from Message m where m.chat.id = :chatId ORDER BY m.dateTime")
    public List<Message> getMessagesFromChat(Long chatId);
    
    @Query("Select m from Message m where m.dateTime = (Select max(me.dateTime) from Message me where me.chat=:chat )")
    public Message getLastMessageFromChat (Chat chat);
    
}
