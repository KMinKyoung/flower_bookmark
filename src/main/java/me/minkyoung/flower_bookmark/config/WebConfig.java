package me.minkyoung.flower_bookmark.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/api/**")                    // /api/로 시작하는 모든 요청에 대해
                .allowedOrigins("http://localhost:3000")  // 프론트엔드 주소
                .allowedMethods("*")                      // 모든 HTTP 메서드 허용
                .allowCredentials(true)                   // 쿠키 인증이 필요하면 true
                .maxAge(3600);                            // pre-flight 캐시 유지 시간 (초)
    }
}
