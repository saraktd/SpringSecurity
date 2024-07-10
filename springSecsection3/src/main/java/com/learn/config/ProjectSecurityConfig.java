package com.learn.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {



    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /**
         * below is the customSecurity configurations
         */
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authz -> authz
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices", "/contact","/register").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();

    }

  /*  @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        /*approach 1 were we use withDefaultPasswordEncoder() method
        while creating the user details
         */

    /* UserDetails admin= User.withDefaultPasswordEncoder()
             .username("admin")
             .password("1234")
             .authorities("admin")
             .build();
UserDetails user=User.withDefaultPasswordEncoder()
     .username("user")
     .password("4321")
     .authorities("read")
     .build();

return new InMemoryUserDetailsManager(admin,user);
 }*/
          /*approach 2 were we use noOpPasswordEncoder Bean
        while creating the user details
         */
       /* UserDetails admin = User.withUsername("admin")
                .password("1234")
                .authorities("admin")
                .build();
        UserDetails user = User.withUsername("user")
                .password("4321")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }*/
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/security");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Aa123456");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;

    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}



