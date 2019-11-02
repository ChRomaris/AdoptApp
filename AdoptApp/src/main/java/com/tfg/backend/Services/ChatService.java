package com.tfg.backend.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Daos.IChatDAO;
import com.tfg.backend.Daos.IMessageDAO;
import com.tfg.backend.Daos.IProfileDao;
import com.tfg.backend.Dtos.ChatDTO;
import com.tfg.backend.Dtos.MessageDTO;
import com.tfg.backend.Dtos.ProfileChatReducedDTO;
import com.tfg.backend.Entities.Chat;
import com.tfg.backend.Entities.Message;
import com.tfg.backend.Entities.Profile;

import static com.tfg.backend.Dtos.ChatConversor.toMessage;
import static com.tfg.backend.Dtos.ChatConversor.toMessageDTOList;
import static com.tfg.backend.Dtos.ChatConversor.toChatDTO;

@Service
public class ChatService implements IChatService {
    
    @Autowired
    IMessageDAO messageDAO;
    
    @Autowired
    IChatDAO chatDAO;
    
    @Autowired
    IProfileDao profileDAO;
    
    @Autowired
    IProfileService profileService;

    @Override
    public List<Message> storeMessage(MessageDTO messageDTO) throws InstanceNotFoundException {
	Message message = toMessage(messageDTO);
	Optional<Chat> optionalChat = chatDAO.findById(messageDTO.getChatId());
	Profile profile = profileService.getProfileFromToken(messageDTO.getUserToken());
	
	if(optionalChat.isPresent()) {
	    
	    Chat chat = optionalChat.get();
	    
		message.setChat(chat);
		message.setChecked(false);
		message.setMessageSender(profile);
		messageDAO.save(message);
		
		ChatDTO chatDTO = new ChatDTO();
		chatDTO.setId(chat.getId());
		
		return getMessages(chatDTO);
	}else {
	    
	    throw new InstanceNotFoundException();
	    
	}

    }

    @Override
    public List<Message> getMessages(ChatDTO chatDTO) {
	List<Message> messageList = messageDAO.getMessagesFromChat( chatDTO.getId());
	return messageList;
    }
    
    @Override
    public ChatDTO startChat(ChatDTO chatDTO) throws InstanceNotFoundException{
	Profile user1 = profileService.getProfileFromToken(chatDTO.getUserToken());
	Profile user2 = profileDAO.findByUsername(chatDTO.getUsername());
	if (user2 != null) {
	    Chat chat = chatDAO.findChatByUsers(user1, user2);
	    if(chat!=null) {
		return toChatDTO(chat);
	    }else {
		Chat createdChat = new Chat();
		createdChat.setSender(user1);
		createdChat.setReceiver(user2);
		
		Chat returnedChat = chatDAO.save(createdChat);
		
		return toChatDTO(returnedChat);
	    }
	}else {
	    throw new InstanceNotFoundException();
	}

	
    }
    
    @Override
    public List<ProfileChatReducedDTO> getChats (String userToken){
	List<ProfileChatReducedDTO> returnedChats = new ArrayList<>();
	Profile profile = profileService.getProfileFromToken(userToken);
	
	List<Chat> chats = chatDAO.getUserChats(profile);
	
	chats.forEach((chat)->{
	   ProfileChatReducedDTO chatReduced = new ProfileChatReducedDTO();
	   Message lastMessage = messageDAO.getLastMessageFromChat(chat);
	   if(chat.getReceiver().getUsername() == profile.getUsername()) {
	       chatReduced.setUsername(chat.getSender().getUsername());
	   }
	   else {
	       chatReduced.setUsername(chat.getReceiver().getUsername());
	   }
	   
	   chatReduced.setLastMessage(lastMessage);
	   returnedChats.add(chatReduced);
	});
	
	return returnedChats;
    }

}
