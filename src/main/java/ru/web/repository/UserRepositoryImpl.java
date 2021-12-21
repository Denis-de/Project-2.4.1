package ru.web.repository;

import org.springframework.stereotype.Repository;
import ru.web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User readUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User deleteUser(Long id) throws NullPointerException {
        User user = readUser(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        return user;
    }

    @Override
    public User getUserByName(String username) {
        TypedQuery query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        User user = (User) query.setParameter("username", username).getSingleResult();
        return user;
    }
}