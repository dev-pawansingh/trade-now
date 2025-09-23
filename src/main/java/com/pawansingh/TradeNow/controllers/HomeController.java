package com.pawansingh.TradeNow.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(){
        return "No home given so overridded";
    }
    @GetMapping("/api")
    public String secured(){
        return "It is Secured api";
    }

}
