package io.library.libmgmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.library.libmgmtsys.model.Book;
import io.library.libmgmtsys.service.LibraryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    LibraryService libraryService;

    @GetMapping("/searchBooks")
    public List<Book> searchBooks(@RequestParam(name = "bookName") String bookName) {
        return libraryService.fetchBooksByName(bookName);
    }

    @GetMapping("/books")
    public List<Book> fetchBooks() {
        return libraryService.fetchAllBooks();
    }
}
