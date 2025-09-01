package com.pawansingh.TradeNow.entities;

import com.pawansingh.TradeNow.domain.VerificationType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class TwoFactorAuth {
    boolean isEnabled = false;
    VerificationType sendTo;
}
