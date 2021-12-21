
package ru.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.model.User;
import ru.web.service.UserService;
import ru.web.service.UserServiceImpl;

@Controller
public class UserController {

    private UserService userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-page";
    }

    @GetMapping("/users/{id}")
    public String show(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.readUser(id);
            model.addAttribute("users", user);
        return "user-page";
    }
}