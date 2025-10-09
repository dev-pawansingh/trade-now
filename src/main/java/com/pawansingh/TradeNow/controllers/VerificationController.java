package com.pawansingh.TradeNow.controllers;

import com.pawansingh.TradeNow.services.EmailService;
import com.pawansingh.TradeNow.services.UserService;
import com.pawansingh.TradeNow.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {
    private final VerificationService verificationService;
    private final UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    public VerificationController(VerificationService verificationService, UserService userService) {
        this.verificationService = verificationService;
        this.userService = userService;
    }




}
