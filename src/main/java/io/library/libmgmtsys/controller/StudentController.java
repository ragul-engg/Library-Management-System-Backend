package io.library.libmgmtsys.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.library.libmgmtsys.model.Book;
import io.library.libmgmtsys.model.Issue;
import io.library.libmgmtsys.service.FileHandlingService;
import io.library.libmgmtsys.service.LibraryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    FileHandlingService fs;

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

    @PostMapping("/lend-book")
    public Issue lendBook(@RequestBody Issue issue) {
        return libraryService.lendBook(issue);
    }

    @DeleteMapping("/return-book")
    public void returnBook(@RequestBody Issue issue) {
        libraryService.returnBook(issue);
    }

    @GetMapping("/lend-book")
    public List<Issue> getLendBooks(@RequestParam(name = "userId") long userId) {
        return libraryService.getLendBooks(userId);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fs.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
