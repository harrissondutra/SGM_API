package com.motoclube.gestor.model.entity;

import com.motoclube.gestor.model.to.PatentData;
import com.motoclube.gestor.model.to.PatentDataDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patents", schema = "motoclube")
@Entity
public class Patent extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeral;
    private String title;
    private String description;

    public Patent(PatentData patentData) {
        this.numeral = patentData.getNumeral();
        this.title = patentData.getTitle();
        this.description = patentData.getDescription();
    }

    public Patent(PatentDataDetails patent) {
        this.numeral = patent.getNumeral();
        this.title = patent.getTitle();
        this.description = patent.getDescription();
    }

    public Patent(Patent patentData) {
        this.numeral = patentData.getNumeral();
        this.title = patentData.getTitle();
        this.description = patentData.getDescription();
    }
}
