package ru.web.repository;

import ru.web.model.Role;

import java.util.List;

public interface RoleRepository {
   // List<Role> getAllRoles();

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    Role getDefaultRole();
}
