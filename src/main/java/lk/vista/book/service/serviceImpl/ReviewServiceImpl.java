package lk.vista.book.service.serviceImpl;

import lk.vista.book.dto.ReviewDto;
import lk.vista.book.entity.Review;
import lk.vista.book.entity.ReviewText;
import lk.vista.book.repo.ReviewRepository;
import lk.vista.book.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReviewDto> getReviewsForBook(String isbn) {
        // Implement logic here
        return null;
    }

    @Override
    public ReviewDto getReviewById(Long reviewId) {
        // Implement logic here
        return null;
    }

//    public ReviewDto saveReview(ReviewDto reviewDto) {
//        try {
//            // Convert DTO to entity using ModelMapper
//            Review review = modelMapper.map(reviewDto, Review.class);
//
//            // Save the entity
//            Review savedReview = reviewRepository.save(review);
//
//            // Convert entity back to DTO using ModelMapper
//            return modelMapper.map(savedReview, ReviewDto.class);
//        } catch(Exception e) {
//            // You can log the exception or take other action as needed
//            e.printStackTrace();
//            throw new RuntimeException("Error while saving review: " + e.getMessage());
//        }
//    }

    public ReviewDto saveReview(ReviewDto reviewDto) {
        try {
            Review c = modelMapper.map(reviewDto, Review.class);
            reviewRepository.save(c);
            return reviewDto;
        } catch(Exception e) {
            // You can log the exception or take other action as needed
            e.printStackTrace();
            throw new RuntimeException("Error while saving review: " + e.getMessage());
        }
    }

    @Override
    public ReviewDto updateReview(Long reviewId, ReviewDto reviewDto) {
        // Implement logic here
        return null;
    }

    @Override
    public void deleteReview(Long reviewId) {
        // Implement logic here
    }

    @Override
    public List<ReviewDto> getReviewsByUser(Long userId) {
        // Implement logic here
        return null;
    }

}
