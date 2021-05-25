package com.example.demo.rest;

import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    private UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/auth")
    public User getAuthorized() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getByEmail(username);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping(value = "/users")
    public User createUser(@RequestBody User user) {
        System.out.println(user.toString());
        userService.add(user);

        return user;
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable Long id) {
        User user = userService.getById(id);
        userService.delete(userService.getById(id));
        return user;
    }

    @PutMapping(value = "/users/{id}")
    public User editUser(@RequestBody User user) {
        userService.update(user);
        return user;
    }

}
