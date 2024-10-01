package com.motoclube.gestor.repository;

import com.motoclube.gestor.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    UserDetails findByLogin(String username);
}
