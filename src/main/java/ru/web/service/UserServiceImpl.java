package ru.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.web.models.User;
import ru.web.repository.UserRepositiry;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepositiry userRepositiry;

    @Autowired
    public UserServiceImpl(UserRepositiry userRepositiry) {
        this.userRepositiry = userRepositiry;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositiry.getAllUsers();
    }

    @Override
    public void createUser(User user) {
        userRepositiry.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepositiry.updateUser(user);
    }

    @Override
    public User readUser(Long id) {
        return userRepositiry.readUser(id);
    }

    @Override
    public User delete(Long id) {
        return userRepositiry.delete(id);
    }
}
