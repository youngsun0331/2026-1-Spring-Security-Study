package com.gdghongik.springsecurity.global.security;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(CustomUserDetails userDetails){

        Date now = new Date();
        Date expiredAt = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .subject(userDetails.getMemberId().toString())
                .claim("username",userDetails.getUsername())
                .claim("role",userDetails.getRole().name())
                .issuedAt(now)
                .expiration(expiredAt)
                .signWith(getSecretKey())
                .compact();
    }

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }


    public Claims getClaims(String token){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isValid(String token) {
        try{
            getClaims(token);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
