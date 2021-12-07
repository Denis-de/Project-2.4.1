package ru.web.init;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.web.model.Role;
import ru.web.model.User;
import ru.web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {


    private final UserService userService;

    public DBInit(UserService userService) {
        this.userService = userService;
    }


    @PostConstruct
    @Transactional
    public void myInit() {
        Set<Role> setAdmin = new HashSet<>();
        Set<Role> setUser = new HashSet<>();
        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        setAdmin.add(roleAdmin);
        User admin = new User("ADMIN", "ADMIN", "ADMIN", 21, "aaa", setAdmin);
        setUser.add(roleUser);
        User user = new User("USER", "USER", "USER", 22, "uuu", setUser);
        userService.createUser(admin);
        userService.createUser(user);
    }
}