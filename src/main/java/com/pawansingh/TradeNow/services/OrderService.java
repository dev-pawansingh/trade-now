package com.pawansingh.TradeNow.services;

import com.pawansingh.TradeNow.domain.OrderType;
import com.pawansingh.TradeNow.model.Coin;
import com.pawansingh.TradeNow.model.Order;
import com.pawansingh.TradeNow.model.OrderItem;
import com.pawansingh.TradeNow.model.User;

import java.util.List;

public interface OrderService {

    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId);

    List<Order> getAllOrdersForUser(Long userId, String orderType,String assetSymbol);

    void cancelOrder(Long orderId);

//    Order buyAsset(CreateOrderRequest req, Long userId, String jwt) throws Exception;

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;

//    Order sellAsset(CreateOrderRequest req,Long userId,String jwt) throws Exception;


}
