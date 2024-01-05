package com.nisum.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.nisum.demo.helpers.Constants.EMAIL_REGEX;
import static com.nisum.demo.helpers.Constants.PASSWORD_REGEX;

@Data
@Entity
@Table(name = "USER_APP")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private String name;

    @Pattern(regexp = EMAIL_REGEX)
    private String email;

    @Pattern(regexp = PASSWORD_REGEX)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;

    private LocalDateTime lastLogin;

    private String token;

    private Boolean isActive;

    @PrePersist
    public void onPrePersist() {
        this.setPassword(new BCryptPasswordEncoder().encode(this.getPassword()));
        this.setLastLogin(LocalDateTime.now());
        this.setIsActive(true);
    }

    @PreUpdate
    public void onPreUpdate() {
        this.setPassword(new BCryptPasswordEncoder().encode(this.getPassword()));
    }
}
