package com.pawansingh.TradeNow.repositories;

import com.pawansingh.TradeNow.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin,String> {
}
