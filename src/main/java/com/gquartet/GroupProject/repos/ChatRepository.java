package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatRepository extends JpaRepository<Chat, Integer>{
    
}
