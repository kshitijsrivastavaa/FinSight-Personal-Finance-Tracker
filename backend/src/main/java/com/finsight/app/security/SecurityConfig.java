@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();

    // ✅ Allow ALL origins (any domain) – fine for a demo/portfolio API
    config.setAllowedOriginPatterns(List.of("*"));

    // Allow standard HTTP methods
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

    // Allow any headers (Content-Type, Authorization, etc.)
    config.setAllowedHeaders(List.of("*"));

    // Allow cookies / Authorization header
    config.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    return source;
}
