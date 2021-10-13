package ru.web.repository;

import ru.web.model.User;

import java.util.List;

public interface UserRepositiry {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User readUser(Long id);
    User delete(Long id);
}
