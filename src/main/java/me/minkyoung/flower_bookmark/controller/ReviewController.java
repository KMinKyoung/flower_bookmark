package me.minkyoung.flower_bookmark.controller;

import me.minkyoung.flower_bookmark.dto.ReviewRequestDto;
import me.minkyoung.flower_bookmark.dto.ReviewResponseDto;
import me.minkyoung.flower_bookmark.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/books/{bookId}/reviews")
    public ResponseEntity<ReviewResponseDto> createReview(@PathVariable Long bookId,
                                                          @RequestBody ReviewRequestDto RequestDto) {
        ReviewResponseDto created = reviewService.createReview(bookId, RequestDto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/books/{bookId}/reviews")
    public ResponseEntity<List<ReviewResponseDto>> listByBook(@PathVariable Long bookId){
        List<ReviewResponseDto> reviews = reviewService.getReviewByBook(bookId);
        return ResponseEntity.ok(reviews);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/users/me/reviews")
    public ResponseEntity<List<ReviewResponseDto>> listMyReviews(){
        List<ReviewResponseDto> myReviews = reviewService.getMyReview();
        return ResponseEntity.ok(myReviews);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long reviewId, @RequestBody ReviewRequestDto RequestDto){
        ReviewResponseDto updated = reviewService.updateReview(reviewId, RequestDto);
        return ResponseEntity.ok(updated);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId){
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
