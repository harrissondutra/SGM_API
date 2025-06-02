package com.motoclube.gestor.members.repository;

import com.motoclube.gestor.members.model.entity.Patent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatentRepository extends JpaRepository<Patent, Long> {
}
