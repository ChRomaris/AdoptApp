package com.tfg.backend.Services;

import java.util.List;

import javax.management.InstanceNotFoundException;

import com.tfg.backend.Dtos.ChatDTO;
import com.tfg.backend.Dtos.MessageDTO;
import com.tfg.backend.Dtos.ProfileChatReducedDTO;
import com.tfg.backend.Entities.Message;

public interface IChatService {
    public List<Message> storeMessage (MessageDTO messageDTO) throws InstanceNotFoundException;
    public List<Message> getMessages (ChatDTO chatDTO);
    public ChatDTO startChat(ChatDTO chatDTO) throws InstanceNotFoundException;
    List<ProfileChatReducedDTO> getChats(String userToken);
}
