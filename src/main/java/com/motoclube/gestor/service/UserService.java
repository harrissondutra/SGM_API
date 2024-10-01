package com.motoclube.gestor.service;


import com.motoclube.gestor.model.entity.User;
import com.motoclube.gestor.model.to.AuthRequest;
import com.motoclube.gestor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;
    public User create(AuthRequest authRequest) {
        var password = passwordEncoder.encode(authRequest.password());
        var user = new User();
        user.setLogin(authRequest.login());
        user.setPassword(password);
        return repository.save(user);
    }
}
