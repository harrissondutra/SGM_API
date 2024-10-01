package com.motoclube.gestor.model.to;

import com.motoclube.gestor.enums.DisciplinaryMeasureType;
import com.motoclube.gestor.model.entity.Address;
import com.motoclube.gestor.model.entity.Member;
import com.motoclube.gestor.model.entity.Patent;
import com.motoclube.gestor.model.entity.PositionMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private Long id;
    private String name;
    private String nickname;
    private String phone;
    private Address address;
    private String cpf;
    private String patent;
    private String position;
    private List<Patent> patentHistory = new ArrayList<>();
    private List<PositionMember> positionHistory = new ArrayList<>();;
    private List<DisciplinaryMeasureType> disciplinaryMeasureList = new ArrayList<>();;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.nickname = member.getNickname();
        this.phone = member.getPhone();
        this.address = member.getAddress();
        this.cpf = member.getCpf();
        this.patent = member.getPatent().getTitle();
        this.position = member.getPosition().getName();
        this.patentHistory = member.getPatentHistory();
        this.positionHistory = member.getPositionHistory();
        this.disciplinaryMeasureList = member.getDisciplinaryMeasureList();
    }
}
