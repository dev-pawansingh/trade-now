package com.pawansingh.TradeNow.request;

import com.pawansingh.TradeNow.domain.OrderType;
import lombok.Data;


@Data
public class CreateOrderRequest {
    private String coinId;
    private double quantity;
    private OrderType orderType;
}
