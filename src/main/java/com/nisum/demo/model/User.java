package com.nisum.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static com.nisum.demo.helpers.Constants.EMAIL_REGEX;
import static com.nisum.demo.helpers.Constants.PASSWORD_REGEX;

@Data
@Entity
@Table(name = "USER_APP")
@EntityListeners(value = AuditingEntityListener.class)
public class User {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;

    @Pattern(regexp = EMAIL_REGEX)
    private String email;

    @Pattern(regexp = PASSWORD_REGEX)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

    private LocalDateTime lastLogin;

    private String token;

    private Boolean isActive = true;
}
