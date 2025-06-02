package com.motoclube.gestor.motoclube.repository;

import com.motoclube.gestor.motoclube.model.Motoclube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoclubeRepository extends JpaRepository<Motoclube, Long> {
}
