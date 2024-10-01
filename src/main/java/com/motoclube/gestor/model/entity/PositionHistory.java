package com.motoclube.gestor.model.entity;

import com.motoclube.gestor.enums.PositionMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*@Audited
@AuditTable(value = "position_history_audit", schema = "motoclube")*/
@Table(name = "position_history", schema = "motoclube")
@Entity
public class PositionHistory extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PositionMember position;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "member_id", updatable = false, insertable = false)
    private Member member;

    public PositionHistory(Member member, PositionMember positionMember) {
        this.member = member;
        this.position = positionMember;
        this.startDate = LocalDate.now();
    }
}
