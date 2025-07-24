package me.minkyoung.flower_bookmark.service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.dto.OrderResponseDto;
import me.minkyoung.flower_bookmark.entity.*;
import me.minkyoung.flower_bookmark.repository.BookRepository;
import me.minkyoung.flower_bookmark.repository.CartItemRepository;
import me.minkyoung.flower_bookmark.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartItemRepository cartItemRepository;

    @Transactional
    public OrderResponseDto createOrder(User user){
        //유저 장바구니 가져오기
        List<CartItem> cartItems = cartItemRepository.findAllByUser(user);

        if(cartItems.isEmpty()){
            throw new IllegalArgumentException("장바구니가 비어져있습니다.");
        }

        //초 ㅇ가격 계산

        int totlaPrice = cartItems.stream()
                .mapToInt(item -> item.getBook().getPrice() * item.getQuantity()).sum();

        //주문 생성
        Order order = new Order(user,totlaPrice);

        //주문 항목 생성
        for(CartItem cartItem : cartItems){
            Book book = cartItem.getBook();
            int quantity = cartItem.getQuantity();
            int price = book.getPrice() * quantity;

            OrderItem orderItem = new OrderItem(book,quantity,price);
            order.addOrderItem(orderItem);
        }
        //저장
        orderRepository.save(order);

        //장바구니 비우기
        cartItemRepository.deleteAll(cartItems);

        return new OrderResponseDto(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDto> getOrders(User user){
        List<Order> orders = orderRepository.findAllByUser(user);
        return orders.stream()
                .map(OrderResponseDto::new)
                .toList();
    }

    @Transactional
    public void cancelOrder(User user, Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("해당 주문은 존재하지 않습니다."));
        if(!order.getUser().getId().equals(user.getId())){
            throw new IllegalArgumentException("본인의 주문만 취소 가능합니다.");
        }
        order.cancel();
    }

    @Transactional
    public OrderResponseDto getOrderDetail(User user, Long orderId){
        Order order = orderRepository.findByIdAndUser(orderId,user).orElseThrow(()-> new IllegalArgumentException("해당 주문을 찾을 수 없습니다."));
        return new OrderResponseDto(order);
    }
}
