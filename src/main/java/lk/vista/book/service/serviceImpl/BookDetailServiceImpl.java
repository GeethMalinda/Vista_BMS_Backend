package lk.vista.book.service.serviceImpl;

import lk.vista.book.dto.BookDetailDTO;
import lk.vista.book.entity.BookDetail;
import lk.vista.book.enums.BookCategory;
import lk.vista.book.repo.BookDetailRepository;
import lk.vista.book.service.BookDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<BookDetailDTO> getBooksByCategory(String category) {
        BookCategory bookCategory;

        try {
            bookCategory = BookCategory.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category: " + category);
        }

        List<BookDetailDTO> bookDetailDTOS = bookDetailRepository.findByCategory(bookCategory)
                .stream()
                .map(bookDetail -> modelMapper.map(bookDetail, BookDetailDTO.class))
                .collect(Collectors.toList());

        return bookDetailDTOS;
    }

//    @Override
//    public BookDetailDTO saveBook(BookDetailDTO bookDetailDTO) {
//        BookDetail bookDetail = modelMapper.map(bookDetailDTO, BookDetail.class);
//        BookDetail savedBookDetail = bookDetailRepository.save(bookDetail);
//        return modelMapper.map(savedBookDetail, BookDetailDTO.class);
//    }

    @Override
    public BookDetailDTO saveBook(BookDetailDTO bookDetailDTO, MultipartFile bookFile, MultipartFile coverFile) {
        BookDetail bookDetail = modelMapper.map(bookDetailDTO, BookDetail.class);

        // Assuming you have setFile and setCover methods in your BookDetail class
        // You can save your file anywhere you want, this is just a basic example
//            bookDetail.setBookFile(bookFile.getBytes());
//            bookDetail.setCoverFile(coverFile.getBytes());
        System.out.println(bookFile);
        System.out.println(coverFile);

        BookDetail savedBookDetail = bookDetailRepository.save(bookDetail);
        return modelMapper.map(savedBookDetail, BookDetailDTO.class);
    }

    @Override
    public BookDetailDTO updateBook(BookDetailDTO bookDetailDTO) {
        BookDetail existingBookDetail = bookDetailRepository.findById(bookDetailDTO.getIsbn())
                .orElseThrow(() -> new IllegalArgumentException("Book not found with this isbn: " + bookDetailDTO.getIsbn()));

        double newRating = bookDetailDTO.getRate();
        existingBookDetail.setRatingCount(existingBookDetail.getRatingCount() + 1);
        existingBookDetail.setRatingSum(existingBookDetail.getRatingSum() + newRating);
        existingBookDetail.setAverageRating(existingBookDetail.getRatingSum() / existingBookDetail.getRatingCount());

        modelMapper.typeMap(BookDetailDTO.class, BookDetail.class).
                addMappings(mapper -> mapper.skip(BookDetail::setIsbn)).map(bookDetailDTO, existingBookDetail);

        BookDetail updatedBookDetail = bookDetailRepository.save(existingBookDetail);
        BookDetailDTO updatedBookDetailDTO = modelMapper.map(updatedBookDetail, BookDetailDTO.class);

        return updatedBookDetailDTO;
    }


    @Override
    public void deleteBook(String isbn) {
        bookDetailRepository.deleteById(isbn);
    }
}
