package com.assesment.securityservice.repository;

import com.assesment.securityservice.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository  extends JpaRepository<UserCredential,Long> {
    Optional<UserCredential> findByEmail(String username);
}
