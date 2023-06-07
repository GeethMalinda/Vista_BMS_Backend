package lk.vista.book.controller;

import lk.vista.book.entity.BookDetail;
import lk.vista.book.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookDetailController {

    @Autowired
    private BookDetailService bookDetailService;

    @GetMapping
    public List<BookDetail> getAllBooks() {
        return bookDetailService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public BookDetail getBookByIsbn(@PathVariable String isbn) {
        return bookDetailService.getBookByIsbn(isbn);
    }

    @PostMapping
    public BookDetail createBook(@RequestBody BookDetail bookDetail) {
        return bookDetailService.createBook(bookDetail);
    }

    @PutMapping
    public BookDetail updateBook(@RequestBody BookDetail bookDetail) {
        return bookDetailService.updateBook(bookDetail);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        bookDetailService.deleteBook(isbn);
    }
}
