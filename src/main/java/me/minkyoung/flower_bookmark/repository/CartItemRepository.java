package me.minkyoung.flower_bookmark.repository;

import me.minkyoung.flower_bookmark.entity.CartItem;
import me.minkyoung.flower_bookmark.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // 유저별 장바구니 목록 조회
    List<CartItem> findAllByUser(User user);
    // 동일한 책이 장바구니에 이미 담겨 있는지 확인
    Optional<CartItem> findByUserAndBookId(User user, Long bookId);
}
