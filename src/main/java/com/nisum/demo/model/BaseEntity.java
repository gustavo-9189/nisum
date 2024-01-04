package com.nisum.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    private UUID id = UUID.randomUUID();

    @CreatedBy
    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created;

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private LocalDateTime modified;
}
