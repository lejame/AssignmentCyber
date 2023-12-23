package com.example.demo.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/greeting")
    public String login(){
        return "Login";
    }
    @PostMapping("/welcome/{name}")
    public String welcome(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "Welcome";
    }
}
