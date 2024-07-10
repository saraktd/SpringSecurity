package com.learn.controller;

import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController extends AbstractAuditable {

        @GetMapping("/myAccount")
        public String sayWelcome(){

            return "Here are the account details from the db";
        }
    }

