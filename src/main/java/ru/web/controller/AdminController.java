
package ru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.model.Role;
import ru.web.model.User;
//import ru.web.service.RoleService;
//import ru.web.service.RoleService;
import ru.web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {
    private UserService userService;

    @Autowired
    public  AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String allUsers(Model model) {
        List<User> user = userService.getAllUsers();
        model.addAttribute("users", user);
        return "user-list";
    }


    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/admin";
    }
   /* @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user")User user, @RequestParam(required = false) String roleAdmin,
                             @RequestParam(required = false) String roleUser) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("ROLE_USER"));
        if(roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roles.add(roleService.getRoleByName("ROLE_ADMIN"));
        }
        if(roleUser != null && roleUser.equals("ROLE_USER")) {
            roles.add(roleService.getRoleByName("ROLE_USER"));
        }
        user.setRoles(roles);
        userService.createUser(user);
        return "redirect:/admin";
    }
*/
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable(value = "id", required = true) Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin";

   /* @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable(value = "id", required = true) Long id, Model model) {
        User user = userService.readUser(id);
        Set<Role> roles = user.getRoles();
        for(Role role : roles) {
            if(role.equals(roleService.getRoleByName("ROLE_ADMIN"))) {
                model.addAttribute("roleAdmin", true);
            }
            if(role.equals(roleService.getRoleByName("ROLE_USER"))) {
                model.addAttribute("roleUser", true);
            }
        }
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(required = false) String roleAdmin,
                             @RequestParam(required = false) String roleUser) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("ROLE_USER"));
        if(roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roleService.getRoleByName("ROLE_ADMIN");
        }
        if(roleUser != null && roleUser.equals("ROLE_USER")) {
            roleService.getRoleByName("ROLE_USER");
        }
        user.setRoles(roles);
        userService.updateUser(user);
        return "redirect:/admin";*/
    }
}
