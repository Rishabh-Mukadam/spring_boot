package org.ridam.spring_security.repository;


import org.ridam.spring_security.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles,Long> {


    Optional<Roles> findByRollName(String name);
}
