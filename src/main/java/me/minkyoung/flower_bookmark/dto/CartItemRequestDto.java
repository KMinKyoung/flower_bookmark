package me.minkyoung.flower_bookmark.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartItemRequestDto {
    private Long bookId;
    private int quantity;
}
