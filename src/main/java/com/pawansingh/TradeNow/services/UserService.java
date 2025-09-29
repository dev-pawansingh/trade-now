package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.domain.VerificationType;
import com.pawansingh.TradeNow.entities.UserEntity;

public interface UserService {

    UserEntity findUserProfileByJwt(String jwt) throws Exception;
    UserEntity findUserByEmail(String email) throws Exception;
    UserEntity findUserById(Long userId) throws Exception;
    UserEntity enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, UserEntity user);
    UserEntity updatePassword(UserEntity user, String newPass);


}
