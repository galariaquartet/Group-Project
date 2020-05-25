package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Chat;
import java.util.List;

public interface ChatService {

    public List<Chat> listAll();

    public void save(Chat chat);

}
