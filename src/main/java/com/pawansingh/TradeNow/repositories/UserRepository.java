package com.pawansingh.TradeNow.repositories;

import com.pawansingh.TradeNow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

}
