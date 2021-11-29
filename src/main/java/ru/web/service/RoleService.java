package ru.web.service;

import ru.web.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    Role getDefaultRole();
}
