package ru.web.repository;

import org.springframework.stereotype.Repository;
import ru.web.model.User;

import java.util.List;


public interface UserRepository {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(Long id);

    User deleteUser(Long id);
}
