/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author xiens
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String userForm(Model model) {
        model.addAttribute("userlist", userRepository.findAll());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/users")
    public String userSubmit(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        model.addAttribute("userlist", userRepository.findAll());
        return "users";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "redirect:/";
    }

    @GetMapping("/findByUserId")
    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }

    @RequestMapping("/save")
    public String process() {

        userRepository.save(new User("Jack", "Smith"));
        userRepository.save(new User("Adam", "Johnson"));
        userRepository.save(new User("Bro", "Johnson"));
        userRepository.save(new User("OO Long", "Johnson"));
        userRepository.save(new User("Evan", "Smith"));

        return "Done";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "";
        result = userRepository.findById(id).toString();
        return result;
    }

}
