@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();

    // ✅ EASIEST: allow ALL origins for this demo API
    config.setAllowedOrigins(List.of("*"));

    // Allow all standard HTTP methods
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

    // Allow all headers (Content-Type, Authorization, etc.)
    config.setAllowedHeaders(List.of("*"));

    // We are NOT using cookies, so credentials can be false (simpler CORS)
    config.setAllowCredentials(false);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    return source;
}
