package lk.vista.book.controller;

import lk.vista.book.dto.BookDetailDTO;
import lk.vista.book.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookDetailController {

    @Autowired
    private BookDetailService bookDetailService;

    @GetMapping
    public ResponseEntity<List<BookDetailDTO>> getAllBooks() {
        List<BookDetailDTO> bookDetailDTOs = bookDetailService.getAllBooks();
        return ResponseEntity.ok(bookDetailDTOs);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDetailDTO> getBookByIsbn(@PathVariable String isbn) {
        BookDetailDTO bookDetailDTO = bookDetailService.getBookByIsbn(isbn);
        return ResponseEntity.ok(bookDetailDTO);
    }

    @PostMapping
    public ResponseEntity<BookDetailDTO> createBook(@RequestBody BookDetailDTO bookDetailDTO) {
        BookDetailDTO createdBookDetailDTO = bookDetailService.saveBook(bookDetailDTO);
        return ResponseEntity.ok(createdBookDetailDTO);
    }

    @PutMapping
    public ResponseEntity<BookDetailDTO> updateBook(@RequestBody BookDetailDTO bookDetailDTO) {
        BookDetailDTO updatedBookDetailDTO = bookDetailService.updateBook(bookDetailDTO);
        return ResponseEntity.ok(updatedBookDetailDTO);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookDetailService.deleteBook(isbn);
        return ResponseEntity.ok().build();
    }
}
