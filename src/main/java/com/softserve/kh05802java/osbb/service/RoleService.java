package com.softserve.kh05802java.osbb.service;

import com.softserve.kh05802java.osbb.model.Role;

import java.util.List;

public interface RoleService {
    Role create(Role role);

    Role readById(long id);

    Role update(Role role);

    void delete(long id);

    List<Role> getAll();
}
