package com.pawansingh.TradeNow.repositories;

import com.pawansingh.TradeNow.model.Wallet;
import com.pawansingh.TradeNow.model.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,Long> {

    List<WalletTransaction> findByWalletOrderByDateDesc(Wallet wallet);

}
