package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.domain.VerificationType;
import com.pawansingh.TradeNow.entities.UserEntity;
import com.pawansingh.TradeNow.entities.VerificationCode;
import org.springframework.stereotype.Service;

public interface VerificationCodeService {
    VerificationCode sendVerificationCode(UserEntity user, VerificationType verificationType);
    VerificationCode getVerificationCodeById(Long id) throws Exception;
    VerificationCode getVerificationCodeByUser(Long userId);
//    Boolean verifyOtp(String otp,VerificationCode verificationCode);
    void deleteVerificationCodeById(VerificationCode verificationCode);

}
