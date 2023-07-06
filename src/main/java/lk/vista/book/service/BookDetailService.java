package lk.vista.book.service;

import lk.vista.book.dto.BookDetailDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookDetailService {

    List<BookDetailDTO> getAllBooks();

    BookDetailDTO getBookByIsbn(String isbn);

    BookDetailDTO saveBook(BookDetailDTO bookDetailDTO, MultipartFile bookFile, MultipartFile coverFile) throws IOException;

    BookDetailDTO updateBook(BookDetailDTO bookDetailDTO);

    void deleteBook(String isbn);

    List<BookDetailDTO> getBooksByCategory(String category);
}
