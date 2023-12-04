package lk.vista.book.controller;

import lk.vista.book.dto.ReviewDto;
import lk.vista.book.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/book/{isbn}")
    public ResponseEntity<List<ReviewDto>> getReviewsForBook(@PathVariable String isbn) {
        return ResponseEntity.ok(reviewService.getReviewsForBook(isbn));
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable Long reviewId) {
        return ResponseEntity.ok(reviewService.getReviewById(reviewId));
    }

    @PostMapping
    public ResponseEntity<ReviewDto> saveReview(@RequestBody ReviewDto reviewDTO) {
        return ResponseEntity.ok(reviewService.saveReview(reviewDTO));
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long reviewId, @RequestBody ReviewDto reviewDTO) {
        return ResponseEntity.ok(reviewService.updateReview(reviewId, reviewDTO));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getReviewsByUser(userId));
    }
}
