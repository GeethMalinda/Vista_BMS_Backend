package lk.vista.book.service.impl;

import lk.vista.book.dto.BookDetailDTO;
import lk.vista.book.entity.BookDetail;
import lk.vista.book.repository.BookDetailRepository;
import lk.vista.book.service.BookDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookDetailServiceImpl implements BookDetailService {

    @Autowired
    private BookDetailRepository bookDetailRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BookDetailDTO> findAllBooks() {
        return bookDetailRepository.findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookDetailDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDetailDTO> findBookByIsbn(String isbn) {
        return bookDetailRepository.findById(isbn)
                .map(book -> modelMapper.map(book, BookDetailDTO.class));
    }

    @Override
    public BookDetailDTO saveBook(BookDetailDTO bookDetailDto) {
        BookDetail bookDetail = modelMapper.map(bookDetailDto, BookDetail.class);
        BookDetail savedBook = bookDetailRepository.save(bookDetail);
        return modelMapper.map(savedBook, BookDetailDTO.class);
    }

    @Override
    public void deleteBook(String isbn) {
        bookDetailRepository.deleteById(isbn);
    }
}
