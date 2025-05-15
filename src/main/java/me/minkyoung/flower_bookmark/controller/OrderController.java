package me.minkyoung.flower_bookmark.controller;

import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.dto.OrderResponseDto;
import me.minkyoung.flower_bookmark.entity.User;
import me.minkyoung.flower_bookmark.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<OrderResponseDto> createOrder(@AuthenticationPrincipal User user) {
        OrderResponseDto orderResponseDto = orderService.createOrder(user);
        return ResponseEntity.ok(orderResponseDto);
    }


    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<OrderResponseDto>> getOrders(@AuthenticationPrincipal User user) {
        List<OrderResponseDto> orderResponseDtos = orderService.getOrders(user);
        return ResponseEntity.ok(orderResponseDtos);
    }

    @PutMapping("/{orderId}/cancel")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long orderId, @AuthenticationPrincipal User user) {
        orderService.cancelOrder(user, orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<OrderResponseDto> getOrderDetails(@PathVariable Long orderId, @AuthenticationPrincipal User user) {
        OrderResponseDto order = orderService.getOrderDetail(user, orderId);
        return ResponseEntity.ok(order);
    }
}
