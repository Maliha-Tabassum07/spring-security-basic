package com.maliha.securitypractice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager)throws Exception{
        httpSecurity
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth-> {
                    auth
                            .requestMatchers(HttpMethod.GET,"/security/welcome").permitAll()
                            .requestMatchers(HttpMethod.GET,"/security/user").authenticated()
                            .requestMatchers(HttpMethod.GET,"security/role").hasAnyRole("user","admin")
                            .requestMatchers(HttpMethod.GET,"/security/role/admin").hasRole("admin")
                            .requestMatchers(HttpMethod.GET,"/security/role/user/**").hasRole("user")
                            .requestMatchers(HttpMethod.GET,"/security/authority/read").hasRole("READ_ONLY")
                            .requestMatchers(HttpMethod.GET,"/security/authority/edit/**").hasAnyAuthority("EDIT_USER", "EDIT_ADMIN")
                            .anyRequest().authenticated();
                })
                .formLogin(login->
                {login.loginPage("/login");
                })
        ;
                return httpSecurity.build();

    }

}
