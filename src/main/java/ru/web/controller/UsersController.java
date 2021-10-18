
package ru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.web.service.UserService;
import ru.web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String setAllUsers(@RequestParam(required = false) Model model) {
        model.addAttribute("message", userService.getAllUsers());
        return "users/list";
    }
}

