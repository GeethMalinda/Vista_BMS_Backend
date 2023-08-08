package lk.vista.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;          // Unique identifier for the review
    private Long userId;      // User who made the review
    private String bookIsbn;  // Book's ISBN that was reviewed
    private int rating;       // Numeric rating given by the user
    private String reviewText; // Text review/comment by the user
}
