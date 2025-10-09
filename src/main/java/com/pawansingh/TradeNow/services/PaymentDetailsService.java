package com.pawansingh.TradeNow.services;


import com.pawansingh.TradeNow.model.PaymentDetails;
import com.pawansingh.TradeNow.model.User;

public interface PaymentDetailsService {
    PaymentDetails addPaymentDetails(String accountNumber,
                                     String accountHolderName,
                                     String ifsc,
                                     String bankName,
                                     User user
    );

    PaymentDetails getUsersPaymentDetails(User user);


}
