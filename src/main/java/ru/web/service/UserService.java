package ru.web.service;

import ru.web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User readUser(Long id);
    User delete(Long id);
}
