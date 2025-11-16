package com.finsight.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Use our CORS configuration
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // Disable CSRF for stateless API
                .csrf(csrf -> csrf.disable())
                // 🔓 Allow everything (no auth for now)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // 🔓 Completely open CORS for this portfolio project
        config.setAllowedOrigins(List.of("*"));   // any origin
        config.setAllowedMethods(List.of("*"));   // GET, POST, PUT, DELETE, OPTIONS...
        config.setAllowedHeaders(List.of("*"));   // any header
        config.setAllowCredentials(false);        // we don't use cookies

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);   // apply to all endpoints
        return source;
    }
}
