package me.minkyoung.flower_bookmark.service;

import me.minkyoung.flower_bookmark.dto.ReviewRequestDto;
import me.minkyoung.flower_bookmark.dto.ReviewResponseDto;
import me.minkyoung.flower_bookmark.entity.Book;
import me.minkyoung.flower_bookmark.entity.Review;
import me.minkyoung.flower_bookmark.entity.User;
import me.minkyoung.flower_bookmark.repository.BookRepository;
import me.minkyoung.flower_bookmark.repository.ReviewRepository;
import me.minkyoung.flower_bookmark.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    //리뷰 작성
    public ReviewResponseDto createReview(Long bookId, ReviewRequestDto requestDto) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserId(userId).orElseThrow(()->new IllegalArgumentException("유저를 찾을 수 없습니다."));
        Book book = bookRepository.findById(bookId).orElseThrow(()->new IllegalArgumentException("책을 찾을 수 없습니다."));

        Review review = Review.builder()
                .user(user)
                .book(book)
                .content(requestDto.getContent())
                .rating(requestDto.getRating())
                .build();

        Review saved = reviewRepository.save(review);
        return toDto(saved);
    }

    //도서별ㄹ 리뷰 목록 조회
    @Transactional(readOnly = true)
    public List<ReviewResponseDto> getReviewByBook(Long bookId) {
        return reviewRepository.findAllByBookId(bookId).stream().
                map(this::toDto)
                .collect(Collectors.toList());
    }

    // 나의 리뷰 목록 조히ㅗ
    @Transactional(readOnly = true)
    public List<ReviewResponseDto> getMyReview() {
        String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
        return reviewRepository.findByUser_UserId(loginId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // 리뷰 수정
    public ReviewResponseDto updateReview(Long Id, ReviewRequestDto requestDto) {
        Review review = reviewRepository.findById(Id)
                .orElseThrow(()->new IllegalArgumentException("리뷰를 찾을 수 업습니다"));

        //작성자 본인 확인
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!review.getUser().getUserId().equals(userId)) {
            throw new SecurityException("권한이 없습니다.");
        }
        review.setContent(requestDto.getContent());
        review.setRating(requestDto.getRating());
        return toDto(review);
    }

    //리뷰 삭제
    public void deleteReview(Long Id) {
        Review review = reviewRepository.findById(Id)
                .orElseThrow(()->new IllegalArgumentException("리뷰를 찾을 수 없습니다"));
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!review.getUser().getUserId().equals(userId)) {
            throw new SecurityException("삭제 권한이 없습니다");
        }
        reviewRepository.delete(review);
    }

    //엔터티 -> Dto 변환
    private ReviewResponseDto toDto(Review review) {
        return ReviewResponseDto.builder()
                .id(review.getId())
                .userId(review.getUser().getUserId())
                .bookId(review.getBook().getId())
                .content(review.getContent())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

}
