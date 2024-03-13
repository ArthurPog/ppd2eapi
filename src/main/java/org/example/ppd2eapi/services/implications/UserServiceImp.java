package org.example.ppd2eapi.services.implications;

import org.example.ppd2eapi.repositories.UserRepo;
import org.example.ppd2eapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    // dependencies
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // methods

}
