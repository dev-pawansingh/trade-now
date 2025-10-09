package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.domain.WalletTransactionType;
import com.pawansingh.TradeNow.model.Wallet;
import com.pawansingh.TradeNow.model.WalletTransaction;

import java.util.List;

public interface WalletTransactionService {
    WalletTransaction createTransaction(Wallet wallet,
                                        WalletTransactionType type,
                                        String transferId,
                                        String purpose,
                                        Long amount
    );

    List<WalletTransaction> getTransactions(Wallet wallet, WalletTransactionType type);

}
