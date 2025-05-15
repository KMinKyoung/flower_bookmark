package me.minkyoung.flower_bookmark.dto;

import lombok.Getter;
import me.minkyoung.flower_bookmark.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderResponseDto {
    private Long orderId;
    private int totalPrice;
    private String status;
    private LocalDateTime createAt;
    private List<OrderItemResponseDto> orderItems;

    public OrderResponseDto(Order order) {
        this.orderId = order.getId();
        this.totalPrice = order.getTotalPrice();
        this.status = order.getOrderStatus().name();
        this.createAt = order.getCreatedAt();
        this.orderItems = order.getOrderItems()
                .stream()
                .map(OrderItemResponseDto::new)
                .collect(Collectors.toList());
    }
}
