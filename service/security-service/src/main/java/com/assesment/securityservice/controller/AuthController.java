package com.assesment.securityservice.controller;

import com.assesment.securityservice.dto.AuthRequest;
import com.assesment.securityservice.dto.LoginResponse;
import com.assesment.securityservice.dto.ResponseDTO;
import com.assesment.securityservice.dto.UserRegistrationDto;
import com.assesment.securityservice.entity.UserCredential;
import com.assesment.securityservice.exception.OperationFailedException;
import com.assesment.securityservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseDTO<String> addNewUser(@RequestBody UserRegistrationDto user) throws OperationFailedException {
        String msg = service.saveUser(user);
        return new ResponseDTO(true,msg,null);
    }

//    Login api
    @PostMapping("/token")
    public ResponseEntity<LoginResponse> getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return ResponseEntity.ok(service.generateToken(authRequest.getUsername()));
        } else {
            throw new RuntimeException("invalid access");
        }
    }


//    is logged in
    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam("token") String token) {
        return ResponseEntity.ok(service.validateToken(token));
    }
}
