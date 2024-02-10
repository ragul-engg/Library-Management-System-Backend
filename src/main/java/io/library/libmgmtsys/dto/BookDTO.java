package io.library.libmgmtsys.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BookDTO {
    private long bookId;
    private String bookName;
    private String authorName;
    private int price;
    private MultipartFile file;
}
