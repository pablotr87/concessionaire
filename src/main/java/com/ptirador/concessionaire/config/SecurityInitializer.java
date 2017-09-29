package com.ptirador.concessionaire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.nio.charset.StandardCharsets;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    @Bean
    public Filter getCharacterEncodingFilter() {
        return new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true, true);
    }

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter",
                getCharacterEncodingFilter());
        characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}