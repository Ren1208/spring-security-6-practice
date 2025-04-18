package ru.semenchenko.springcourse.FirstSecurityApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ru.semenchenko.springcourse.FirstSecurityApp.security.AuthProviderImpl;

/**
 * @author Artyom Semenchenko
 */

@EnableWebSecurity
public class SecurityConfig {

    private final AuthProviderImpl authProvider;

    public SecurityConfig(AuthProviderImpl authProvider) {
        this.authProvider = authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authProvider);

        return http.build();
    }
}

