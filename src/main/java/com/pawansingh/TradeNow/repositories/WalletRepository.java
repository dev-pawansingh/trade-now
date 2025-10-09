package com.pawansingh.TradeNow.repositories;

import com.pawansingh.TradeNow.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Wallet findByUserId(Long userId);
}
