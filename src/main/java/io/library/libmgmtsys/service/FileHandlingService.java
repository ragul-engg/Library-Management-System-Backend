package io.library.libmgmtsys.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.library.libmgmtsys.dto.BookDTO;
import io.library.libmgmtsys.model.Book;

@Service
public class FileHandlingService {
    private final Path root = Paths.get("D:/e-books");

    public Book save(String book, MultipartFile file) {
        Book b;
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            b = new Book();
            ObjectMapper objectMapper = new ObjectMapper();
            b = objectMapper.readValue(book, Book.class);
            b.setBookUrl(file.getOriginalFilename());
        } catch (Exception e) {
            throw new RuntimeException("Could not store file");
        }
        return b;
    }

    public Book save(BookDTO book) {
        Book b;
        try {
            MultipartFile file = book.getFile();
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            b = new Book(book.getBookId(), book.getBookName(), book.getAuthorName(), book.getPrice(),
                    file.getOriginalFilename());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return b;
    }

    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
