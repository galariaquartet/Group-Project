package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Chat;
import com.gquartet.GroupProject.repos.ChatRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository repo;

    @Override
    public List<Chat> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Chat chat) {
        repo.save(chat);
    }

}
