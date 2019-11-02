package com.tfg.backend.Dtos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tfg.backend.Entities.Chat;
import com.tfg.backend.Entities.Message;

public class ChatConversor {

    public static final Chat toChat (ChatDTO chatDTO) {
	Chat chat = new Chat();
	chat.setId(chatDTO.getId());
	
	return chat;
    }
    
    public static final ChatDTO toChatDTO (Chat chat) {
	ChatDTO chatDTO = new ChatDTO();
	
	chatDTO.setId(chat.getId());
	chatDTO.setMessages(chat.getMessages());
	
	return chatDTO;
    }
    
    public static final Message toMessage (MessageDTO messageDTO) {
	Message message = new Message();
	message.setDateTime(Calendar.getInstance());
	message.setText(messageDTO.getText());
	
	return message;
    }
    
    public static final MessageDTO toMessageDTO (Message message) {
	MessageDTO messageDTO = new MessageDTO();
	messageDTO.setChatId(message.getChat().getId());
	messageDTO.setDateTime(message.getDateTime());
	messageDTO.setId(message.getId());
	messageDTO.setText(message.getText());
	messageDTO.setUsername(message.getMessageSender().getUsername());
	
	return messageDTO;
    }
    
    public static final List<MessageDTO> toMessageDTOList(List<Message> messageList){
	List<MessageDTO> messageDTOList = new ArrayList<>();
	messageList.forEach((message)->{
	    messageDTOList.add(toMessageDTO(message));
	});
	
	return messageDTOList;
    }
    
    
    
}
