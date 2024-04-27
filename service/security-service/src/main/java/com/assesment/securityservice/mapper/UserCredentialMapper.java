package com.assesment.securityservice.mapper;

import com.assesment.securityservice.dto.UserCredentialDto;
import com.assesment.securityservice.entity.UserCredential;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialMapper {
    public UserCredentialDto toDto(UserCredential entity) {
        if (entity == null) {
            return null;
        }

        UserCredentialDto dto = new UserCredentialDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setUserRole(entity.getUserRole());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public UserCredential toEntity(UserCredentialDto dto) {
        if (dto == null) {
            return null;
        }

        UserCredential entity = new UserCredential();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setUserRole(dto.getUserRole());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}
