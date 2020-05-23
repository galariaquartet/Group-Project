package com.gquartet.GroupProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @RequestMapping("/preGame")
    public String preGame() {
        return "game";
    }
}