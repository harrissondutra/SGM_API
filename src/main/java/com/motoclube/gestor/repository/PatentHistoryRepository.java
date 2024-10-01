package com.motoclube.gestor.repository;

import com.motoclube.gestor.model.entity.Member;
import com.motoclube.gestor.model.entity.Patent;
import com.motoclube.gestor.model.entity.PatentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatentHistoryRepository extends JpaRepository<PatentHistory, Long> {

    @Query("SELECT ph.patent FROM PatentHistory ph WHERE ph.member.id = :id")
    List<Patent> findPatentHistoryByMember_Id(Long id);



}