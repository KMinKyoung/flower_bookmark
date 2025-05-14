package me.minkyoung.flower_bookmark.repository;

import me.minkyoung.flower_bookmark.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByBookId(Long bookId);
    List<Review> findByUser_UserId(String userId);
}
