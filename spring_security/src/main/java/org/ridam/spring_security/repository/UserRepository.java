package org.ridam.spring_security.repository;

import org.ridam.spring_security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
