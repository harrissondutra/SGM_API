package com.motoclube.gestor.members.repository;

import com.motoclube.gestor.members.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    UserDetails findByLogin(String username);
}
