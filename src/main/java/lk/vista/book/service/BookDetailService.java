package lk.vista.book.service;

import lk.vista.book.dto.BookDetailDTO;
import java.util.List;

public interface BookDetailService {

    List<BookDetailDTO> getAllBooks();

    BookDetailDTO getBookByIsbn(String isbn);

    BookDetailDTO saveBook(BookDetailDTO bookDetailDTO);

    BookDetailDTO updateBook(BookDetailDTO bookDetailDTO);

    void deleteBook(String isbn);
}
