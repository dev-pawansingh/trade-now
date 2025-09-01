package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.entities.UserEntity;
import com.pawansingh.TradeNow.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity registerUser(UserEntity user){
        try{
            UserEntity newUser = new UserEntity();
            newUser.setFullName(user.getFullName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            UserEntity saved = userRepository.save(newUser);
            return saved;
        }catch (Exception e){
            log.warn(e.toString());
            return null;
        }
    }

}
