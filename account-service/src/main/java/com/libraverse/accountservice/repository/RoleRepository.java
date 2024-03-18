package com.libraverse.accountservice.repository;

import com.libraverse.accountservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

}

