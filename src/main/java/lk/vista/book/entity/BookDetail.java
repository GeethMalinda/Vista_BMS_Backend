package lk.vista.book.entity;

import lk.vista.book.enums.BookStatus;
import lk.vista.book.enums.BookFormat;
import lk.vista.book.enums.BookLanguage;
import lk.vista.book.enums.BookCategory;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDetail {

    @Id
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "name")
    private String name;

    @Column(name = "img_url")
    private String imageURL;

    @Column(name = "author")
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private BookCategory category;

    @Column(name = "publisher")
    private String publisher;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private BookLanguage language;

    @Column(name = "pages")
    private int pages;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "format")
    private BookFormat format;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "average_rating")
    private double averageRating = 0;

    @Column(name = "rating_count")
    private int ratingCount;

    @Column(name = "rating_sum")
    private double ratingSum;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ebook_file_id")
    private FileData ebookFile;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cover_photo_id")
    private FileData coverPhoto;

}
