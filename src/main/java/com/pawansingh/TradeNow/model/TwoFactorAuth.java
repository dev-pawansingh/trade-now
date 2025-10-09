package com.pawansingh.TradeNow.model;

import com.pawansingh.TradeNow.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;
    private VerificationType sendTo;
}
