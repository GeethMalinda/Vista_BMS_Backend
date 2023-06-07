package lk.vista.book.dto;

import lk.vista.book.enums.BookStatus;
import lk.vista.book.enums.BookType;
import lombok.*;

import java.time.LocalDate;

/**
 * Data Transfer Object for book details
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDTO {

    private String isbn;
    private String name;
    private String author;
    private String publisher;
    private String language;
    private int pages;
    private LocalDate publicationDate;
    private BookStatus bookStatus;
    private BookType bookType;
}
