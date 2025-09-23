package com.pawansingh.TradeNow.controllers;

import com.pawansingh.TradeNow.config.JwtProvider;
import com.pawansingh.TradeNow.entities.UserEntity;
import com.pawansingh.TradeNow.repositories.UserRepository;
import com.pawansingh.TradeNow.response.AuthResponse;
import com.pawansingh.TradeNow.services.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody UserEntity user) throws Exception{

                UserEntity isEmailExist = userRepository.findUserByEmail(user.getEmail());

                if (isEmailExist!= null){
                    throw new Exception("User with this mail already Exist");
                }
                UserEntity newUser = new UserEntity();
                newUser.setFullName(user.getFullName());
                newUser.setEmail(user.getEmail());
                newUser.setPassword(user.getPassword());
                newUser.setMobile(user.getMobile());

//            UserEntity saved =
                userRepository.save(newUser);

                Authentication auth = new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                );

                SecurityContextHolder.getContext().setAuthentication(auth);
                String jwt = JwtProvider.generateToken(auth);
                AuthResponse res = new AuthResponse();
                res.setJwt(jwt);
                res.setStatus(true);
                res.setMessage("Registered Successfully");
                return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> login(@RequestBody UserEntity user) throws Exception{

        String userName = user.getEmail();
        String password = user.getPassword();

        Authentication auth = authenticate(userName,password);

        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = JwtProvider.generateToken(auth);
        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("Logged in Successfully");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    private Authentication authenticate(String userName, String password) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
        if(userDetails == null){
            throw new BadCredentialsException("Invalid Username");
        }
        if(!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("Invalid Password");
        }else{
            return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
        }
    }

}
