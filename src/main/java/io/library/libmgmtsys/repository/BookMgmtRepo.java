package io.library.libmgmtsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.library.libmgmtsys.model.Book;

public interface BookMgmtRepo extends JpaRepository<Book, Long> {
    List<Book> findByBookNameContains(String bookName);
}
