package com.example.AuthorizationServer.repos;

import com.example.AuthorizationServer.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chaklader on 11/11/21
 */
public interface RoleRepo extends JpaRepository<Role, Long> {


}
