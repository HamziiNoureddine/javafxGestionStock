package com.hamzi.hnia.dz.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Autowired
    private CustumuserDetailService custumuserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("Security chain created");
        http
                .sessionManagement((s)->{
                    s.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });
        return http.build();
    }
@Bean
public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}



@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return new ProviderManager(Collections.singletonList(getAuthenticationProvider()));
}
@Bean
public DaoAuthenticationProvider getAuthenticationProvider(){
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    authenticationProvider.setUserDetailsService(custumuserDetailService);
    return authenticationProvider;

}

}
