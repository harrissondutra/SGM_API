package com.motoclube.gestor.members.model.to;

import com.motoclube.gestor.members.model.entity.Patent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatentData {
    private String numeral;
    private String title;
    private String description;

    public PatentData(Patent patent) {
        this.numeral = patent.getNumeral();
        this.title = patent.getTitle();
        this.description = patent.getDescription();
    }

    public PatentData(PatentDataDetails patent) {
        this.numeral = patent.getNumeral();
        this.title = patent.getTitle();
        this.description = patent.getDescription();
    }
}
