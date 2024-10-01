package com.motoclube.gestor.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

//@Audited
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class EntityBase {

    @JsonIgnore
    @CreationTimestamp
    @Column(updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @UpdateTimestamp
    @Column(updatable = false, insertable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @UpdateTimestamp
    @Column(updatable = false, insertable = false)
    private LocalDateTime deletedAt;

    @JsonIgnore
    @LastModifiedBy
    @JoinColumn(updatable = false, insertable = false)
    @ManyToOne
    private User modifiedByUser;

    @JsonIgnore
    @CreatedBy
    @ManyToOne
    @JoinColumn(updatable = false, insertable = false)
    private User deletedByUser;

    @JsonIgnore
    @CreatedBy
    @ManyToOne
    @JoinColumn(updatable = false, insertable = false)
    private User createdByUser;
}
