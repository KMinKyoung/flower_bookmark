package me.minkyoung.flower_bookmark.repository;

import me.minkyoung.flower_bookmark.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
