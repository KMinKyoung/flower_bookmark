package me.minkyoung.flower_bookmark.dto;

import lombok.Getter;
import me.minkyoung.flower_bookmark.entity.CartItem;

@Getter
public class CartItemResponseDto {
    private Long cartId;
    private Long bookId;
    private String bookTitle;
    private int quantity;
    private int price;

    public CartItemResponseDto(CartItem cartItem) {
        this.cartId = cartItem.getId();
        this.bookId = cartItem.getBook().getId();
        this.bookTitle = cartItem.getBook().getTitle();
        this.quantity = cartItem.getQuantity();
        this.price = cartItem.getBook().getPrice();
    }
}
