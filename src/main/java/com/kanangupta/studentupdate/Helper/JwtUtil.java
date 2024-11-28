package com.kanangupta.studentupdate.Helper;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private final String SECRET_KEY = "PhIsyxtORPYufZWKuyJ9kp4k/2SYhrCAWIEGd+QM2nE=";

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }



    public boolean isTokenValid(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            Date expirationDate = claims.getExpiration();

            // Check if the token is expired
            if (expirationDate.before(new Date())) {
                return false; // Token has expired
            }

            return true; // Token is valid and not expired
        } catch (JwtException | IllegalArgumentException e) {
            return false; // Invalid or malformed token
        }
    }




    public String extractUsername(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    
}