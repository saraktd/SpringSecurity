package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringSecurityLearnApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityLearnApplication2.class, args);
    }

}
