package me.minkyoung.flower_bookmark.controller;

import lombok.AllArgsConstructor;
import me.minkyoung.flower_bookmark.dto.CartItemRequestDto;
import me.minkyoung.flower_bookmark.dto.CartItemResponseDto;
import me.minkyoung.flower_bookmark.entity.User;
import me.minkyoung.flower_bookmark.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartItemController {
   private final CartItemService cartItemService;

    //장바구니 도서 추가
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Void> addToCart(@RequestBody CartItemRequestDto requestDto,
                                          @AuthenticationPrincipal User user) {
        cartItemService.addToCart(user, requestDto);
        return ResponseEntity.ok().build();
    }

    //장바구니 조회
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<CartItemResponseDto>> getCart(@AuthenticationPrincipal User user) {
        List<CartItemResponseDto> cart = cartItemService.getCart(user);
        return ResponseEntity.ok(cart);
    }
    
    // 장바구니 항목 삭제
    @DeleteMapping("/{cartItemId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long cartItemId,
                                               @AuthenticationPrincipal User user) {
        cartItemService.deleteCartItem(user, cartItemId);
        return ResponseEntity.ok().build();
    }
}
