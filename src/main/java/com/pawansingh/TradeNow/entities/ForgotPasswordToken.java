package com.pawansingh.TradeNow.entities;

import com.pawansingh.TradeNow.domain.VerificationType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ForgotPasswordToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne
    private UserEntity user;

    private String otp;
    private VerificationType verificationType;
    private String sendTo;
}
