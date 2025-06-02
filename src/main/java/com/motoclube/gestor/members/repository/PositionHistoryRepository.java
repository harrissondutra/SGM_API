package com.motoclube.gestor.members.repository;

import com.motoclube.gestor.members.enums.PositionMember;
import com.motoclube.gestor.members.model.entity.PositionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionHistoryRepository extends JpaRepository<PositionHistory, Long> {
    @Query("SELECT ph.position FROM PositionHistory ph WHERE ph.member.id = :memberId")
    List<PositionMember> findPositionHistoryByMember_Id(Long memberId);
}
