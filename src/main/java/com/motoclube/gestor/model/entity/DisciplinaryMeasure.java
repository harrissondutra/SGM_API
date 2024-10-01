package com.motoclube.gestor.model.entity;

import com.motoclube.gestor.enums.DisciplinaryMeasureType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*@Audited
@AuditTable(value = "disciplinary_measures_audit", schema = "motoclube")*/
@Table(name = "disciplinary_measures", schema = "motoclube")
@Entity
public class DisciplinaryMeasure extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DisciplinaryMeasureType tipo; // Suspensão, Desligamento, etc.
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "member_id", updatable = false, insertable = false)
    private Member member;

}
