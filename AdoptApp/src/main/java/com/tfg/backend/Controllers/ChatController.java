package com.tfg.backend.Controllers;

import java.security.Principal;
import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.Dtos.ChatDTO;
import com.tfg.backend.Dtos.MessageDTO;
import com.tfg.backend.Dtos.ProfileChatReducedDTO;
import com.tfg.backend.Entities.Message;
import com.tfg.backend.Services.IChatService;

@RestController
@RequestMapping("/chat/")
public class ChatController {

    @Autowired
    IChatService chatService;
    
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    /*
     * This MessageMapping annotated method will be handled by
     * SimpAnnotationMethodMessageHandler and after that the Message will be
     * forwarded to Broker channel to be forwarded to the client via WebSocket
     */
    
//    @MessageMapping("/secured/room") 
//    public void sendSpecific( @Payload MessageDTO messageDTO) throws Exception 
//    { 
//	List<Message> messageDTOList = chatService.storeMessage(messageDTO);
//        simpMessagingTemplate.convertAndSendToUser(
//         messageDTO.getUsername(), "/secured/user/queue/specific-user", messageDTO); 
//    }
    
    @MessageMapping("/all")
    @SendTo("/topic/all")
    public List<Message> post (@Payload MessageDTO messageDTO, Principal user) throws InstanceNotFoundException {
	List<Message> messageDTOList = chatService.storeMessage(messageDTO);
	System.out.println(user.getName());
	simpMessagingTemplate.convertAndSendToUser(
	         user.getName(), "/topic/all", messageDTO); 
        return messageDTOList;
    }
    
    @RequestMapping("/history")
    public List<Message> getChatHistory(@Payload ChatDTO chatDTO) {
        return chatService.getMessages(chatDTO);
    }    
    
    @PostMapping("/start")
    public ChatDTO startChat(@RequestBody ChatDTO chatDTO) throws InstanceNotFoundException {
        return chatService.startChat(chatDTO);
    }
    
    @GetMapping("/active")
    public List<ProfileChatReducedDTO> getChats (@RequestParam String token){
	return chatService.getChats(token);
    }
}
