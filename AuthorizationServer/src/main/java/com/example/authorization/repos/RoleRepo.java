package com.example.authorization.repos;

import com.example.authorization.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chaklader on 11/11/21
 */
public interface RoleRepo extends JpaRepository<Role, Long> {


}
