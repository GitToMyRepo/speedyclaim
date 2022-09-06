package com.allstate.speedyclaim.service;

import com.allstate.speedyclaim.data.UserRepository;
import com.allstate.speedyclaim.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements com.allstate.speedyclaim.service.UserManagementService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        user.setPassword( bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
