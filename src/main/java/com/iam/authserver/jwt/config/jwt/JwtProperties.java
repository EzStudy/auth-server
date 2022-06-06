package com.iam.authserver.jwt.config.jwt;

public interface JwtProperties {
    String SECRET = "1234";
    int EXPIRATION_TIME = 864000000;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
