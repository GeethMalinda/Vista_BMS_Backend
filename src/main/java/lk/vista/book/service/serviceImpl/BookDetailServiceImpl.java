package lk.vista.book.service.serviceImpl;

import lk.vista.book.dto.BookDetailDTO;
import lk.vista.book.entity.BookDetail;
import lk.vista.book.repo.BookDetailRepository;
import lk.vista.book.service.BookDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDetailServiceImpl implements BookDetailService {

    @Autowired
    private BookDetailRepository bookDetailRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BookDetailDTO> getAllBooks() {
        return bookDetailRepository.findAll()
                .stream()
                .map(bookDetail -> modelMapper.map(bookDetail, BookDetailDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDetailDTO getBookByIsbn(String isbn) {
        BookDetail bookDetail = bookDetailRepository.findById(isbn)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with this isbn: " + isbn));
        return modelMapper.map(bookDetail, BookDetailDTO.class);
    }

    @Override
    public BookDetailDTO saveBook(BookDetailDTO bookDetailDTO) {
        BookDetail bookDetail = modelMapper.map(bookDetailDTO, BookDetail.class);
        BookDetail savedBookDetail = bookDetailRepository.save(bookDetail);
        return modelMapper.map(savedBookDetail, BookDetailDTO.class);
    }

    @Override
    public BookDetailDTO updateBook(BookDetailDTO bookDetailDTO) {
        BookDetail bookDetail = modelMapper.map(bookDetailDTO, BookDetail.class);
        BookDetail updatedBookDetail = bookDetailRepository.save(bookDetail);
        return modelMapper.map(updatedBookDetail, BookDetailDTO.class);
    }

    @Override
    public void deleteBook(String isbn) {
        bookDetailRepository.deleteById(isbn);
    }
}
