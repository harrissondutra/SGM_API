package com.motoclube.gestor.model.entity;

import com.motoclube.gestor.model.to.PositionMemberData;
import com.motoclube.gestor.model.to.PositionMemberDataDetails;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "positions", schema = "motoclube")
@Entity
public class PositionMember extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeral;
    private String name;
    private String description;

    public PositionMember(PositionMemberData positionMemberData) {
        this.numeral = positionMemberData.numeral();
        this.name = positionMemberData.name();
        this.description = positionMemberData.description();
    }

    public PositionMember(PositionMember position) {
        this.numeral = position.getNumeral();
        this.name = position.getName();
        this.description = position.getDescription();
    }

    public PositionMember(PositionMemberDataDetails position) {
        this.numeral = position.getNumeral();
        this.name = position.getName();
        this.description = position.getDescription();
    }
}
