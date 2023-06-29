package lk.vista.book.dto;

import lk.vista.book.enums.BookStatus;
import lk.vista.book.enums.BookFormat;
import lk.vista.book.enums.BookLanguage;
import lk.vista.book.enums.BookCategory;

import lombok.*;

import java.math.BigDecimal;
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
    private String imageURL;
    private String author;
    private BookCategory category;
    private String publisher;
    private BookLanguage language;
    private int pages;
    private LocalDate publicationDate;
    private BookStatus status;
    private BookFormat format;
    private BigDecimal price;
    private String description;
    private BigDecimal discount;
    private double rate;

}
