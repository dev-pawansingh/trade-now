package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.model.TwoFactorOTP;
import com.pawansingh.TradeNow.model.User;
import org.springframework.stereotype.Service;

@Service
public interface TwoFactorOTPService {
    TwoFactorOTP createTwoFactorOTP(User user, String otp, String jwt);
    TwoFactorOTP findByUser(Long userId);
    TwoFactorOTP findById(String id);
    boolean verifyTwoFactorOTP(TwoFactorOTP twoFactorOTP, String otp);
    void deleteTwoFactorOTP(TwoFactorOTP twoFactorOTP);
}
