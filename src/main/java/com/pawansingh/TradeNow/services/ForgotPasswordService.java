package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.domain.VerificationType;
import com.pawansingh.TradeNow.model.ForgotPasswordToken;
import com.pawansingh.TradeNow.model.User;

public interface ForgotPasswordService {
    ForgotPasswordToken createToken(User user, String id, String otp, VerificationType verificationType, String sendTo);

    ForgotPasswordToken findById(String id);
    ForgotPasswordToken findByUser(Long userId);
    void deleteToken(ForgotPasswordToken token);

}
