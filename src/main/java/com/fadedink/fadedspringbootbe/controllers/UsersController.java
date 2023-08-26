package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.entities.User;
import com.fadedink.fadedspringbootbe.exceptions.ResourceNotFoundException;
import com.fadedink.fadedspringbootbe.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @PostMapping("users")
    public @ResponseBody String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "New user added";
    }

    @DeleteMapping("/users/{id}")
    public @ResponseBody String removeUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "User removed";
    }

    @PutMapping("/users")
    public @ResponseBody String updateuser (@RequestBody User user) {
        User updateUser = userRepository.findById(user.id).orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id: " + user.id));
        updateUser.setUsername(user.username);
        updateUser.setPassword(user.password);
        updateUser.setEmail(user.email);
        return "User details updated";
    }

    @PostMapping("/login")
    public @ResponseBody ObjectNode validateUser(@RequestBody User user) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();
        int loginAttempt = userRepository.validateLogin(user.username, user.password);

        if (loginAttempt >= 1) {
            response.put("message", "Login Successful");
            response.put("loggedIn", true);
            return response;
        } else {
            response.put("message", "Invalid username or password");
            response.put("loggedIn", false);
            return response;
        }
    }
}
