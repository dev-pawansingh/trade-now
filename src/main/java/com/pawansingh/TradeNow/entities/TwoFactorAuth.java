package com.pawansingh.TradeNow.entities;

import com.pawansingh.TradeNow.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;
}
