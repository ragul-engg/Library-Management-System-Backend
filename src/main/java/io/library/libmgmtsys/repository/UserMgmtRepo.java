package io.library.libmgmtsys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.library.libmgmtsys.model.User;

public interface UserMgmtRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUserName(String userName);

}
