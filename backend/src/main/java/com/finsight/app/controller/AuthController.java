package com.finsight.app.controller;

import com.finsight.app.model.User;
import com.finsight.app.security.JwtUtil;
import com.finsight.app.service.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    public static class RegisterRequest {
        @NotBlank
        public String name;
        @Email
        public String email;
        @NotBlank
        public String password;
    }

    public static class LoginRequest {
        @Email
        public String email;
        @NotBlank
        public String password;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User user = userService.register(request.name, request.email, request.password);
        String token = jwtUtil.generateToken(user.getEmail(), Map.of("userId", user.getId()));
        return ResponseEntity.ok(Map.of(
                "token", token,
                "user", Map.of(
                        "id", user.getId(),
                        "name", user.getName(),
                        "email", user.getEmail()
                )
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> userOpt = userService.login(request.email, request.password);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }
        User user = userOpt.get();
        String token = jwtUtil.generateToken(user.getEmail(), Map.of("userId", user.getId()));
        return ResponseEntity.ok(Map.of(
                "token", token,
                "user", Map.of(
                        "id", user.getId(),
                        "name", user.getName(),
                        "email", user.getEmail()
                )
        ));
    }
}
