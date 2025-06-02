package com.motoclube.gestor.members.repository;

import com.motoclube.gestor.members.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Long> {
}
