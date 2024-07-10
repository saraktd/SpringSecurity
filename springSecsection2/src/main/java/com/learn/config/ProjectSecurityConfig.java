package com.learn.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /**
         * below is the customSecurity configurations
         */
       /* http.authorizeHttpRequests(authz -> authz
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices", "/contact").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();*/
        /**
         * configuration to denyAll requests
         */
        /*
            http.authorizeHttpRequests(authz -> authz.anyRequest().denyAll())
                    .formLogin(withDefaults())
                    .httpBasic(withDefaults());
            return http.build();
            */
/**
 * configuration to permitAll requests
 */

            http.authorizeHttpRequests(authz -> authz.anyRequest().permitAll())
                    .formLogin(withDefaults())
                    .httpBasic(withDefaults());
            return http.build();

        }

    }

