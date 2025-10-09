package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.domain.VerificationType;
import com.pawansingh.TradeNow.model.User;
import com.pawansingh.TradeNow.model.VerificationCode;

public interface VerificationCodeService {
    VerificationCode sendVerificationCode(User user, VerificationType verificationType);
    VerificationCode getVerificationCodeById(Long id) throws Exception;
    VerificationCode getVerificationCodeByUser(Long userId);
//    Boolean verifyOtp(String otp,VerificationCode verificationCode);
    void deleteVerificationCodeById(VerificationCode verificationCode);

}
