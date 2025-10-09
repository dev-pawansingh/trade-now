package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.exception.WalletException;
import com.pawansingh.TradeNow.model.Order;
import com.pawansingh.TradeNow.model.User;
import com.pawansingh.TradeNow.model.Wallet;

public interface WalletService {
    Wallet getUserWallet(User user);
    Wallet addBalance(Wallet wallet, Long money);
    Wallet findWalletById(Long id) throws Exception;
    Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception;
    Wallet payOrderPayment(Order order, User user) throws WalletException;

}
