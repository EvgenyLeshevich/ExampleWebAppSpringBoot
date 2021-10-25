package com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.repository;

import com.evgeniy.spring.ExampleWebAppSpringBootWithLetsCode.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
