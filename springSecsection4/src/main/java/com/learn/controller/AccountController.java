package com.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

        @GetMapping("/myAccount")
        public String sayWelcome(){

            return "Here are the account details from the db";
        }
    }

