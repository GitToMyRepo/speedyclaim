package com.allstate.speedyclaim.controller;

import com.allstate.speedyclaim.data.UserRepository;
import com.allstate.speedyclaim.domain.User;
import com.allstate.speedyclaim.service.ClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public Map<String,String> login(@RequestBody Map<String,String> loginData) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String username = userDetails.getUsername();
        logger.info("User is " + username);
        User user = userRepository.findByUsername(username);
        System.out.println("Role is " + user.getRole());

        Map<String,String> response = new HashMap<>();
        response.put("username", username);
        response.put("role", user.getRole().toString());
        return response;
    }
}

