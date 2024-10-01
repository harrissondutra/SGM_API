package com.motoclube.gestor.repository;

import com.motoclube.gestor.model.entity.Patent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatentRepository extends JpaRepository<Patent, Long> {
}
