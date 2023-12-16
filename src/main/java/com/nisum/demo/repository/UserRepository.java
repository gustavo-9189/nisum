package com.nisum.demo.repository;

import com.nisum.demo.model.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findOneByEmailAndIsactive(String email, Boolean active);

}
