package lk.vista.book.dto;

import lk.vista.book.enums.BookStatus;
import lk.vista.book.enums.BookType;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDTO {
    private String isbn;
    private String name;
    private String author;
    private String type;
    private String publisher;
    private String language;
    private String pages;
    private Date date;
    private BookStatus bookStatus;
    private BookType bookType;


}
