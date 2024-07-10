package com.learn.controller;

import com.learn.model.entity.Customer;
import com.learn.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

 private final PasswordEncoder passwordEncoder;
 private final CustomerRepository customerRepository;

 @PostMapping("/register")
public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
    try {
        String hashPwd = passwordEncoder.encode(customer.getPwd());
        log.info("Hashed Password: " + hashPwd);

        customer.setPwd(hashPwd);
        Customer savedCustomer = customerRepository.save(customer);

        if (savedCustomer.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Given user details are successfully registered");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Unable to register user details");
        }
    } catch (Exception ex) {
        log.error("An exception occurred: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("An exception occurred due to " + ex.getMessage());
    }
}



}
