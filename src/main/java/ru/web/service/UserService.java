package ru.web.service;

import org.springframework.stereotype.Service;
import ru.web.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(Long id);

    User deleteUser(Long id);
}
