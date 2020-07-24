package com.example.homework.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/autocomplete")
    public String hw1(Model model, String query){
        return "autocomplete";
    }

    @GetMapping("/facebook")
    public String hw2(Model model, String query){
        return "facebook";
    }

}
