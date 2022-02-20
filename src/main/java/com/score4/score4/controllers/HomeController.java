package com.score4.score4.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String getHelloWOrld(){
        return "Hello Spring";
    }





}
