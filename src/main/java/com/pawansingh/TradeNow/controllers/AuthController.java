package com.pawansingh.TradeNow.controllers;

import com.pawansingh.TradeNow.config.JwtProvider;
import com.pawansingh.TradeNow.entities.TwoFactorOTP;
import com.pawansingh.TradeNow.entities.UserEntity;
import com.pawansingh.TradeNow.repositories.UserRepository;
import com.pawansingh.TradeNow.response.AuthResponse;
import com.pawansingh.TradeNow.services.CustomUserDetailsService;
import com.pawansingh.TradeNow.services.EmailService;
import com.pawansingh.TradeNow.services.TwoFactorOTPService;
import com.pawansingh.TradeNow.utils.OTPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private TwoFactorOTPService twoFactorOTPService;

    @Autowired
    private EmailService emailService;

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

//                if(user.getTwoFactorAuth().isEnabled()){
//
//                }

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
        UserEntity authUser = userRepository.findUserByEmail(userName);

        if(user.getTwoFactorAuth().isEnabled()){
            AuthResponse res = new AuthResponse();
            res.setMessage("Two Factor Authentication is Enabled");
            res.setTwoFactorAuthEnabled(true);
            String otp = OTPUtils.generateOTP();

            TwoFactorOTP oldTwoFactorOTP = twoFactorOTPService.findByUser(authUser.getId());
            if(oldTwoFactorOTP != null){
                twoFactorOTPService.deleteTwoFactorOTP(oldTwoFactorOTP);
            }
            TwoFactorOTP newTwoFactorOTP = twoFactorOTPService.createTwoFactorOTP(authUser,otp,jwt);

            emailService.sendVerificationOTPEmail(userName,otp);

            res.setSession(newTwoFactorOTP.getId());
            return new ResponseEntity<>(res,HttpStatus.ACCEPTED);

        }
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

    public ResponseEntity<AuthResponse> verifySigningOtp(
            @PathVariable String otp, @RequestParam String id) throws Exception {
        TwoFactorOTP twoFactorOTP = twoFactorOTPService.findById(id);
        if(twoFactorOTPService.verifyTwoFactorOTP(twoFactorOTP, otp)){
            AuthResponse res = new AuthResponse();
            res.setMessage("Two Factor Authentication Verified");
            res.setTwoFactorAuthEnabled(true);
            res.setJwt(twoFactorOTP.getJwt());
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        throw new Exception("Invalid OTP");
    }

}
