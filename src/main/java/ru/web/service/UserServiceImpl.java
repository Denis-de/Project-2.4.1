package ru.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.web.repository.UserRepository;
import ru.web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }


    @Override
    public User readUser(Long id) {
        return userRepository.readUser(id);
    }


    @Override
    public User deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }
}
