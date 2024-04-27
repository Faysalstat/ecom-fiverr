package com.assesment.securityservice.service;

import com.assesment.securityservice.dto.LoginResponse;
import com.assesment.securityservice.dto.UserCredentialDto;
import com.assesment.securityservice.dto.UserRegistrationDto;
import com.assesment.securityservice.entity.UserCredential;
import com.assesment.securityservice.exception.OperationFailedException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String saveUser(UserRegistrationDto credential) throws OperationFailedException;
    LoginResponse generateToken(String username);
    Boolean validateToken(String token);

    UserCredentialDto getUserByUserName(String username);
}
