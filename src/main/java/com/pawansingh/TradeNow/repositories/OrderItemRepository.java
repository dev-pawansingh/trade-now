package com.pawansingh.TradeNow.repositories;

import com.pawansingh.TradeNow.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
