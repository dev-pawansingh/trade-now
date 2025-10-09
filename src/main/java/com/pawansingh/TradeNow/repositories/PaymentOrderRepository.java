package com.pawansingh.TradeNow.repositories;

import com.pawansingh.TradeNow.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder,Long> {
}
