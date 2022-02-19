package com.example.cloudstorage_project1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(){

        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("greeting", "Welcome to our website");
        model.addAttribute("time", Instant.now().toString());
        return "hello";
    }
}
