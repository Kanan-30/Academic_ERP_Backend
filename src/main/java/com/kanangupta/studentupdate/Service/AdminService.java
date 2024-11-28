package com.kanangupta.studentupdate.Service;

import com.kanangupta.studentupdate.Exception.CustomException;
import com.kanangupta.studentupdate.Helper.JwtUtil;
import com.kanangupta.studentupdate.dto.AdminLoginRequest;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.SignatureException;


@Service
public class AdminService {


    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(AdminLoginRequest loginRequest) {
        if (adminUsername.equals(loginRequest.getUsername()) && adminPassword.equals(loginRequest.getPassword())) {
            return jwtUtil.generateToken(adminUsername);
        } else {
            throw new RuntimeException("Invalid admin credentials");
        }
    }

    public void validateAdmin(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new CustomException("Invalid Authorization header");
        }

        String token = authHeader.substring(7);

        try {
            if (!jwtUtil.isTokenValid(token)) {
                throw new CustomException("Invalid or expired token");
            }
        } catch (ExpiredJwtException e) {
            // Handle expired token specifically
            throw new CustomException("Token has expired. Please login again.");
        } catch (SignatureException e) {
            // Handle invalid signature specifically
            throw new CustomException("Invalid token signature. Token cannot be trusted.");
        } catch (JwtException e) {
            // General JWT exception (other types of validation failures)
            throw new CustomException("Token validation failed: " + e.getMessage());
        }

        String username = jwtUtil.extractUsername(token);
        if (!adminUsername.equals(username)) {
            throw new CustomException("Unauthorized admin");
        }
    }

}
