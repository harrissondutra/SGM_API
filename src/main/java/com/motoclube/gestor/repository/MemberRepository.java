package com.motoclube.gestor.repository;

import com.motoclube.gestor.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Long> {
}
