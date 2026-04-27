package com.nbang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 모든 API에 대해
                .allowedOrigins("http://localhost:5173") // 리액트 주소 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}