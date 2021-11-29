package ru.web.repository;

import org.springframework.stereotype.Repository;
import ru.web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String role) {
        TypedQuery query = entityManager.createQuery("SELECT u FROM Role u WHERE u.role = :role", Role.class);
        Role roles = (Role)query.setParameter("role", role).getSingleResult();
        return roles;
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getDefaultRole() {
        return getRoleByName("USER_ROLE");
    }
}
