package lk.vista.book.dto;

import lk.vista.book.enums.BookStatus;
import lk.vista.book.enums.BookFormat;
import lk.vista.book.enums.BookLanguage;
import lk.vista.book.enums.BookCategory;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
    private BookCategory category = BookCategory.CATEGORY_NONFICTION;
    private String publisher;
    private BookLanguage language = BookLanguage.SINHALA;
    private int pages;
    private Date publicationDate;
    private BookStatus status = BookStatus.UNAVAILABLE;
    private BookFormat format = BookFormat.EBOOK;
    private BigDecimal price;
    private String description;
    private BigDecimal discount;
    private double rate;

}
