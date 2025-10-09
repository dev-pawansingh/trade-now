package com.pawansingh.TradeNow.services;


import com.pawansingh.TradeNow.model.Coin;
import com.pawansingh.TradeNow.model.User;
import com.pawansingh.TradeNow.model.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchlist(Long userId) throws Exception;

    Watchlist createWatchList(User user);

    Watchlist findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
}
