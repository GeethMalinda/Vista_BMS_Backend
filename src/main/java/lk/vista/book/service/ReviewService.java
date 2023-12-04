package lk.vista.book.service;

import lk.vista.book.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> getReviewsForBook(String isbn);

    ReviewDto getReviewById(Long reviewId);

    ReviewDto saveReview(ReviewDto reviewDto);

    ReviewDto updateReview(Long reviewId, ReviewDto reviewDto);

    void deleteReview(Long reviewId);

    List<ReviewDto> getReviewsByUser(Long userId);
}
