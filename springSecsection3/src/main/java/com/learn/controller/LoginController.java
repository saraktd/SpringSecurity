package com.learn.controller;

import com.learn.model.entity.Customer;
import com.learn.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LoginController {
 private final CustomerRepository customerRepository;
 @PostMapping("/register")
 public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
  Customer savedCustomer = null;
  ResponseEntity response = null;
  try {
   savedCustomer = customerRepository.save(customer);
   if (savedCustomer.getId() > 0) {
    response = ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Given user details are successfully registered");
   }
  } catch (Exception ex) {
   response = ResponseEntity
           .status(HttpStatus.INTERNAL_SERVER_ERROR)
           .body("An exception occured due to " + ex.getMessage());
  }
  return response;
 }



}
