package io.library.libmgmtsys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;
    private String bookName;
    private String authorName;
    private int price;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
