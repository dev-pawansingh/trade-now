package com.pawansingh.TradeNow.services;


import com.pawansingh.TradeNow.model.CoinDTO;
import com.pawansingh.TradeNow.response.ApiResponse;

public interface ChatBotService {
    ApiResponse getCoinDetails(String coinName);

    CoinDTO getCoinByName(String coinName);

    String simpleChat(String prompt);
}
