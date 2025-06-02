package com.motoclube.gestor.members.repository;

import com.motoclube.gestor.members.model.entity.Member;
import com.motoclube.gestor.motoclube.model.Motoclube;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository  extends JpaRepository<Member, Long> {

    List<Member> findMembersByMotoclubeId(Motoclube motoclubeId);

}
