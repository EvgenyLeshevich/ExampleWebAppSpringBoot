package com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.controllers;

import com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.entity.Role;
import com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.entity.User;
import com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if ((userFromDb != null)){
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
