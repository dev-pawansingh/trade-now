package com.pawansingh.TradeNow.repositories;

import com.pawansingh.TradeNow.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserByEmail(String email);

}
