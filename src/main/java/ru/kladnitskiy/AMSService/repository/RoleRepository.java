package ru.kladnitskiy.AMSService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kladnitskiy.AMSService.model.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
