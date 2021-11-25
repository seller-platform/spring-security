package com.choi.security.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.ServletContext;

/**
 * @author choic
 * @since 2021/11/24
 * Spring Boot 애플리케이션을 사용하는 경우 이 이니셜라이저가 필요하지 않습니다.
 * https://www.baeldung.com/spring-boot-security-autoconfiguration
 */
public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) {

		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.register(SecSecurityConfig.class);

		sc.addListener(new ContextLoaderListener(root));
		sc.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
			.addMappingForUrlPatterns(null, false, "/*");
	}
}
