package com.pawansingh.TradeNow.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pawansingh.TradeNow.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
//    @NonNull
    public String fullName;
    public String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String password;

    // setting role to customer by default
    public USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    @Embedded
    public TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
}
