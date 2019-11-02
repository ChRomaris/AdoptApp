package com.tfg.backend.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Chat;
import com.tfg.backend.Entities.Location;
import com.tfg.backend.Entities.Profile;

public interface IChatDAO extends PagingAndSortingRepository<Chat, Long>  {
    
    @Query("Select c From Chat c Where (sender = :user1 and receiver = :user2) or (sender = :user2 and receiver = :user1)")
    public Chat findChatByUsers(Profile user1, Profile user2);
    
    @Query("Select distinct c From Chat c Where sender = :profile or receiver = :profile ")
    public List<Chat> getUserChats(Profile profile);
    
}
