package com.motoclube.gestor.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.motoclube.gestor.enums.DisciplinaryMeasureType;
import com.motoclube.gestor.enums.deserializer.PatentDeserializer;
import com.motoclube.gestor.enums.deserializer.PositionMemberDeserializer;
import com.motoclube.gestor.model.to.MemberData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member", schema = "motoclube")
@Entity
public class Member extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickname;
    private String phone;
    private Address address;
    private String cpf;

    @ManyToOne
    @JsonDeserialize(using = PatentDeserializer.class)
    @JsonProperty("patent")
    private Patent patent;

    @ManyToOne
    @JsonDeserialize(using = PositionMemberDeserializer.class)
    @JsonProperty("position")
    private PositionMember position;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<Patent> patentHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<PositionMember> positionHistory = new ArrayList<>();

    @ElementCollection
    private List<DisciplinaryMeasureType> disciplinaryMeasureList = new ArrayList<>();

    private Boolean active;

    public Member(MemberData memberData) {
        this.name = memberData.getName();
        this.nickname = memberData.getNickname();
        this.phone = memberData.getPhone();
        this.address = memberData.getAddress();
        this.cpf = memberData.getCpf();
        this.active = true;
        this.patentHistory = new ArrayList<>();
        this.positionHistory = new ArrayList<>();
        this.disciplinaryMeasureList = new ArrayList<>();
    }

    @JsonProperty("patent")
    public String getPatentTitle() {
        return patent != null ? patent.getTitle() : null;
    }

    @JsonProperty("position")
    public String getPositionName() {
        return position != null ? position.getName() : null;
    }
}