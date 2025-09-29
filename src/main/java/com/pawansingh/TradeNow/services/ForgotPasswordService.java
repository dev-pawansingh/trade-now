package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.domain.VerificationType;
import com.pawansingh.TradeNow.entities.ForgotPasswordToken;
import com.pawansingh.TradeNow.entities.UserEntity;

public interface ForgotPasswordService {
    ForgotPasswordToken createToken(UserEntity user, String id, String otp, VerificationType verificationType,String sendTo);

    ForgotPasswordToken findById(String id);
    ForgotPasswordToken findByUser(Long userId);
    void deleteToken(ForgotPasswordToken token);

}
