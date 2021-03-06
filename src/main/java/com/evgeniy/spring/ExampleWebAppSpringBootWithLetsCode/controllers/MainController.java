package com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.controllers;

import com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.entity.Message;
import com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.entity.User;
import com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    MessageRepository messageRepo;

    @GetMapping("/")
    public String greeting(Model model) {
        return "homePage";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag, Model model) {
        Message message = new Message(text, tag, user);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);

        return "main";
    }

}