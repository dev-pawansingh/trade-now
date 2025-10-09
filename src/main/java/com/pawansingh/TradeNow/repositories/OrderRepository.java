package com.pawansingh.TradeNow.repositories;

import com.pawansingh.TradeNow.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order>findByUserId(Long userId);
}
