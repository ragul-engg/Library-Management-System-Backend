package io.library.libmgmtsys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.library.libmgmtsys.model.Book;
import io.library.libmgmtsys.model.LoginUser;
import io.library.libmgmtsys.model.User;
import io.library.libmgmtsys.repository.BookMgmtRepo;
import io.library.libmgmtsys.repository.UserMgmtRepo;

@Service
public class LibraryService {
    @Autowired
    UserMgmtRepo libraryMgmtRepo;
    @Autowired
    BookMgmtRepo bookMgmtRepo;
    // @Autowired
    // BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean addUser(User user) {
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        try {
            libraryMgmtRepo.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Optional<User> fetchUserById(long id) {
        return libraryMgmtRepo.findById(id);
    }

    public Optional<User> fetchUserByEmail(String email) {
        return libraryMgmtRepo.findByEmail(email);
    }

    public Optional<User> findByUserName(String name) {
        return libraryMgmtRepo.findByUserName(name);
    }

    public List<User> getAllUsers() {
        return libraryMgmtRepo.findAll();
    }

    public boolean deleteBook(long id) {
        try {
            bookMgmtRepo.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Book addBook(Book book) {
        return bookMgmtRepo.save(book);
    }

    public Map<String, String> authUser(LoginUser user) {
        Optional<User> us = libraryMgmtRepo.findByEmail(user.getEmail());
        Map<String, String> mp = new HashMap<>();
        mp.put("msg", "student");
        if (us.isPresent()) {
            if (us.get().getPassword().equals(user.getPassword())) {
                mp.put("msg", "admin");
                return mp;
            }
        }
        return mp;
    }

    public List<Book> fetchAllBooks() {
        return bookMgmtRepo.findAll();
    }

    public List<Book> fetchBooksByName(String name) {
        return bookMgmtRepo.findByBookNameContains(name);
    }
}
