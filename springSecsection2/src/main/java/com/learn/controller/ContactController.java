package com.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

        @GetMapping("/contact")
        public String saveContactInquiryDetails(){

            return "Inquiry Details are saved to the db";
        }
    }

