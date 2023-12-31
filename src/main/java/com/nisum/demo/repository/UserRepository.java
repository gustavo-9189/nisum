package com.nisum.demo.repository;

import com.nisum.demo.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findOneByEmailAndIsActive(String email, Boolean active);

    List<User> findAllByIsActive(Boolean active);

}
