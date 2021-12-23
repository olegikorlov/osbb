package com.softserve.kh05802java.osbb.repository;

import com.softserve.kh05802java.osbb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
