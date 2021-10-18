package ru.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
//@Transactional
public class UserRepositiryImpl implements UserRepositiry {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserRepositiryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User readUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User delete(Long id) throws NullPointerException {
        User user = readUser(id);
        if(null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }
}
