package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Chat;
import com.gquartet.GroupProject.models.ChatMessage;
import com.gquartet.GroupProject.models.Customer;
import com.gquartet.GroupProject.services.ChatService;
import com.gquartet.GroupProject.services.CustomerService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat.send") //8a paei sth me8odo chat.send 
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        Date date = new Date();

        Customer customer = customerService.getCustomerByUsername(chatMessage.getSender());

        Chat chat = new Chat();
        chat.setMessage(chatMessage.getContent());
        chat.setTimeMessage(date);
        chat.setCustomerId(customer);

        chatService.save(chat);

        return chatMessage;
    }

}
