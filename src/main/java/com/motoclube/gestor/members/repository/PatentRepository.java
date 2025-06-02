package com.motoclube.gestor.members.repository;

import com.motoclube.gestor.members.model.entity.Patent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatentRepository extends JpaRepository<Patent, Long> {
    List<Patent> findByMotoclubeId(Long motoclubeId);
}
