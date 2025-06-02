package com.motoclube.gestor.members.repository;

import com.motoclube.gestor.members.model.entity.PositionMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionMemberRepository extends JpaRepository<PositionMember, Long> {
}
