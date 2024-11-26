package com.kanangupta.studentupdate.Service;

import com.kanangupta.studentupdate.Helper.JwtUtil;
import com.kanangupta.studentupdate.dto.AdminLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {


    private final String adminUsername = "admin";


    private final String adminPassword= "admin123";


    private final String jwtSecret ="PhIsyxtORPYufZWKuyJ9kp4k/2SYhrCAWIEGd+QM2nE=";

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
            throw new RuntimeException("Invalid Authorization header");
        }
        String token = authHeader.substring(7);

        if (!jwtUtil.isTokenValid(token)) {
            throw new RuntimeException("Invalid or expired token");
        }

        String username = jwtUtil.extractUsername(token);
        if (!adminUsername.equals(username)) {
            throw new RuntimeException("Unauthorized admin");
        }
    }
}
