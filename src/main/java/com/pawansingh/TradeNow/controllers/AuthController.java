package com.pawansingh.TradeNow.controllers;

import com.pawansingh.TradeNow.entities.UserEntity;
import com.pawansingh.TradeNow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user){
        UserEntity userEntity = userService.registerUser(user);
        if(userEntity!=null){
            return new ResponseEntity<>(userEntity,HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
