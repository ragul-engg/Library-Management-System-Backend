package io.library.libmgmtsys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.library.libmgmtsys.model.Issue;

public interface IssueMgmtRepo extends JpaRepository<Issue, Long> {
    List<Issue> findByUserId(long userId);

    Optional<Issue> findByUserIdAndBookId(long userId, long bookId);
    
    long deleteByBookId(long bookId);
}
