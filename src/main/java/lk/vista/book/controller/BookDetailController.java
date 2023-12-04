package lk.vista.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.vista.book.dto.BookDetailDTO;
import lk.vista.book.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/category/{category}")
    public ResponseEntity<List<BookDetailDTO>> getBooksByCategory(@PathVariable String category) {
        List<BookDetailDTO> bookDetailDTOs = bookDetailService.getBooksByCategory(category);
        return ResponseEntity.ok(bookDetailDTOs);
    }


    @PostMapping
    public ResponseEntity<BookDetailDTO> createBook(@RequestParam("bookDetail") String bookDetailStr,
                                                    @RequestParam("book") MultipartFile book,
                                                    @RequestParam("cover") MultipartFile cover) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BookDetailDTO bookDetailDTO = null;
        try {
            bookDetailDTO = mapper.readValue(bookDetailStr, BookDetailDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BookDetailDTO createdBookDetailDTO = bookDetailService.saveBook(bookDetailDTO, book, cover);
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
