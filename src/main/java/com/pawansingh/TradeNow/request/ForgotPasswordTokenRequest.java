package com.pawansingh.TradeNow.request;

import com.pawansingh.TradeNow.domain.VerificationType;
import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
    private String sendTo;
    private VerificationType verificationType;
}
