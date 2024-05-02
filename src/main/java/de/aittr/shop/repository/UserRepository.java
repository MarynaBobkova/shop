package de.aittr.shop.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    de.aittr.shop.domain.entity.User findByUsername(String username);

}
