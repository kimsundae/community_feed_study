package org.fastcampus.auth.domain;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class TokenProvider {

    private final SecretKey key;
    public TokenProvider(String secretKey){
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String createToken(Long userId, String role){
        return "";
    }

    public Long getUserId(String token){
        return -1L;
    }

    public String getUserRole(String token){
        return "";
    }
}
