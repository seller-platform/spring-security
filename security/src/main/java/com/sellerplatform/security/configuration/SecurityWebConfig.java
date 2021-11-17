package com.sellerplatform.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Import({WebSecurityConfig.class})
public class SecurityWebConfig implements WebMvcConfigurer {
}
