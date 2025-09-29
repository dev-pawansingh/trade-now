package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.config.JwtProvider;
import com.pawansingh.TradeNow.domain.VerificationType;
import com.pawansingh.TradeNow.entities.TwoFactorAuth;
import com.pawansingh.TradeNow.entities.UserEntity;
import com.pawansingh.TradeNow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findUserProfileByJwt(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromToken(jwt);
        UserEntity user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public UserEntity findUserByEmail(String email) throws Exception {
        UserEntity user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public UserEntity findUserById(Long userId) throws Exception {
        Optional<UserEntity> user = userRepository.findById(userId);
        if(user == null){
            throw new Exception("User not found");
        }
        return user.get();
    }

    @Override
    public UserEntity enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, UserEntity user) {

        TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
        twoFactorAuth.setEnabled(true);
        twoFactorAuth.setSendTo(verificationType);

        user.setTwoFactorAuth(twoFactorAuth);

        return userRepository.save(user);
    }

    @Override
    public UserEntity updatePassword(UserEntity user, String newPass) {
        user.setPassword(newPass);
        return userRepository.save(user);
    }
}
