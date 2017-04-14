package com.ptirador.concessionaire.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({
        "com.ptirador.concessionaire.service",
        "com.ptirador.concessionaire.validator"})
@EnableTransactionManagement
public class SpringRootConfig {
}
