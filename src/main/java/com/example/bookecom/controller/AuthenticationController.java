package com.example.bookecom.controller;

import com.example.bookecom.dtos.AccountDTO;
import com.example.bookecom.dtos.TokenDetails;
import com.example.bookecom.entities.TaiKhoan;
import com.example.bookecom.repository.TaiKhoanRepository;
import com.example.bookecom.service.taikhoan.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1/auth")
public class AuthenticationController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Value("${api.app.jwtExpiration}")
    private Long expiration;
    public AuthenticationController(TaiKhoanService taiKhoanService,TaiKhoanRepository taiKhoanRepository, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider){
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.taiKhoanRepository = taiKhoanRepository;
        this.taiKhoanService = taiKhoanService;
    }
    @PostMapping("/login")
    public ResponseEntity<TokenDetails> login(@Valid @RequestBody AccountDTO accountDTO){
        TaiKhoan taiKhoan = taiKhoanRepository.findByEmail(accountDTO.getEmail());
        if(taiKhoan == null){
            throw new RuntimeException("User hasn't been active or not register");
        }
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountDTO.getEmail(), accountDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //return jwt
            String jwt = jwtTokenProvider.generateToken((ChiTietNguoiDung) authentication.getPrincipal());
            TokenDetails tokenDetails = new TokenDetails();
            tokenDetails.setToken(jwt);
            tokenDetails.setAvatar("andkadaj");
            tokenDetails.setExpired(expiration);
            tokenDetails.setRoles(taiKhoan.getRole());
            tokenDetails.setFullName(taiKhoan.getTen());
            return new ResponseEntity<>(tokenDetails, HttpStatus.OK);
        }
        catch (BadCredentialsException badCredentialsException){
            throw new RuntimeException("Invalid username or password");
        }
    }
}
