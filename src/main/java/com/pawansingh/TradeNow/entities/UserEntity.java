package com.pawansingh.TradeNow.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pawansingh.TradeNow.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    public String mobile;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // we can only write it, can't read it
    public String password;

    // setting role to customer by default
    public USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    @Embedded
    public TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
}
