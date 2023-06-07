package lk.vista.book.entity;

import lk.vista.book.enums.BookStatus;
import lk.vista.book.enums.BookType;

import lombok.*;

import javax.persistence.*;
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

    @Column(name = "author")
    private String author;

    @Column(name = "type")
    private String type;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "language")
    private String language;

    @Column(name = "pages")
    private int pages;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_status")
    private BookStatus bookStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_type")
    private BookType bookType;

}
