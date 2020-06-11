package ru.kladnitskiy.AMSService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kladnitskiy.AMSService.model.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
