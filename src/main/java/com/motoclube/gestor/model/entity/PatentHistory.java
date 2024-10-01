package com.motoclube.gestor.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*@Audited
@AuditTable(value = "patent_history_audit", schema = "motoclube")*/
@Table(name = "patent_history", schema = "motoclube")
@Entity
public class PatentHistory extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patent_id", updatable = false, insertable = false)
    private Patent patent;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "member_id", updatable = false, insertable = false)
    private Member member;

    public PatentHistory(Member member, Patent patent) {
        this.member = member;
        this.patent = patent;
        this.startDate = LocalDate.now();
    }

}
