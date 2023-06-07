package lk.vista.book.service;

import lk.vista.book.dto.BookDetailDTO;
import java.util.List;
import java.util.Optional;

public interface BookDetailService {

    List<BookDetailDTO> findAllBooks();

    Optional<BookDetailDTO> findBookByIsbn(String isbn);

    BookDetailDTO saveBook(BookDetailDTO bookDetailDto);

    void deleteBook(String isbn);
}
