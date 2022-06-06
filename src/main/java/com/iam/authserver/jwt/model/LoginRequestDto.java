package com.iam.authserver.jwt.model;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String userId;
    private String password;
}
