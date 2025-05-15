package me.minkyoung.flower_bookmark.repository;

import me.minkyoung.flower_bookmark.entity.Order;
import me.minkyoung.flower_bookmark.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //유저별 주문 목록 조회
    List<Order> findAllByUser(User user);

    //본인의 주문만 조회
    Optional<Order> findByIdAndUser(Long id, User user);
}
