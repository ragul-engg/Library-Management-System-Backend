package io.library.libmgmtsys.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.library.libmgmtsys.model.Book;
import io.library.libmgmtsys.model.User;
import io.library.libmgmtsys.service.FileHandlingService;
import io.library.libmgmtsys.service.LibraryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    LibraryService libraryService;
    @Autowired
    FileHandlingService fileHandlingService;

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

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable(name = "id") long bookId) {
        return libraryService.getBook(bookId);
    }

    @PostMapping(value = "/upload", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> uploadBook(@RequestPart(name = "book") String book,
            @RequestPart(name = "file") MultipartFile file) {
        // try {
        return ResponseEntity.ok(libraryService.addBook(fileHandlingService.save(book, file)));
        // } catch (Exception e) {
        // return ResponseEntity.internalServerError().body("mgs");
        // }
    }
}
