package com.example.demo.rest;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/auth")
    public User getAuth() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getByEmail(username);
    }
}
