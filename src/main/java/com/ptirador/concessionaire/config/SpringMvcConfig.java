package com.ptirador.concessionaire.config;

import com.ptirador.concessionaire.interceptor.AccessControlInterceptor;
import com.ptirador.concessionaire.interceptor.MenuInterceptor;
import com.ptirador.concessionaire.repository.MenuRepository;
import com.ptirador.concessionaire.repository.UserRepository;
import com.ptirador.concessionaire.service.MenuService;
import com.ptirador.concessionaire.service.MenuServiceImpl;
import com.ptirador.concessionaire.service.UserService;
import com.ptirador.concessionaire.service.UserServiceImpl;
import com.ptirador.concessionaire.views.ExportListSpreadsheetView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Configuration
@ComponentScan(basePackages = {
        "com.ptirador.concessionaire.controller",
        "com.ptirador.concessionaire.security"})
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    private static final String RESOURCES_LOCATION = "/resources/";
    private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

    private final UserRepository userRepository;
    private final MenuRepository menuRepository;

    public SpringMvcConfig(final UserRepository userRepository,
                           final MenuRepository menuRepository) {
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return messageSource;
    }

    @Bean
    public ExportListSpreadsheetView spreadsheetView() {
        return new ExportListSpreadsheetView();
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return localeResolver;
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public MenuService menuService(MenuRepository menuRepository) {
        return new MenuServiceImpl(menuRepository);
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCES_HANDLER)
                .addResourceLocations(RESOURCES_LOCATION);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/accessDenied").setViewName("accessDeniedView");
        registry.addViewController("/administration").setViewName("initAdminView");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(true);
        registry.beanName();
        registry.tiles();
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(
                "classpath:tiles/base-tiles.xml",
                "classpath:tiles/admin-tiles.xml",
                "classpath:tiles/general-tiles.xml"
        );
        tilesConfigurer.setCheckRefresh(true);
        tilesConfigurer.setValidateDefinitions(true);
        return tilesConfigurer;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
        registry.addInterceptor(new AccessControlInterceptor(userService(userRepository), localeResolver()))
                .addPathPatterns("/**")
                .excludePathPatterns(RESOURCES_HANDLER)
                .excludePathPatterns("/general/**");
        registry.addInterceptor(new MenuInterceptor(menuService(menuRepository)))
                .addPathPatterns("/**")
                .excludePathPatterns(RESOURCES_HANDLER)
                .excludePathPatterns("/general/**");
    }
}

