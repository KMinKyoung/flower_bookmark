package me.minkyoung.flower_bookmark.dto;

import lombok.Getter;
import me.minkyoung.flower_bookmark.entity.OrderItem;

@Getter
public class OrderItemResponseDto {
    private Long bookId;
    private String title;
    private int quantity;
    private int price;

    public OrderItemResponseDto(OrderItem item) {
        this.bookId = item.getBook().getId();
        this.title = item.getBook().getTitle();
        this.quantity = item.getQuantity();
        this.price = item.getPrice();
    }
}
