package io.library.libmgmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.library.libmgmtsys.model.Book;
import io.library.libmgmtsys.model.User;
import io.library.libmgmtsys.service.LibraryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    LibraryService libraryService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return libraryService.fetchAllBooks();
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user) {
        return libraryService.addUser(user);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public boolean deleteBook(@PathVariable(name = "id") long bookId) {
        return libraryService.deleteBook(bookId);
    }
}
