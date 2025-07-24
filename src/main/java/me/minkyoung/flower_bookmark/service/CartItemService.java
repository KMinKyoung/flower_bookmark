package me.minkyoung.flower_bookmark.service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.dto.CartItemRequestDto;
import me.minkyoung.flower_bookmark.dto.CartItemResponseDto;
import me.minkyoung.flower_bookmark.entity.Book;
import me.minkyoung.flower_bookmark.entity.CartItem;
import me.minkyoung.flower_bookmark.entity.User;
import me.minkyoung.flower_bookmark.repository.BookRepository;
import me.minkyoung.flower_bookmark.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;

    //장바구니에 추가
    public void addToCart(User user, CartItemRequestDto requestDto){
        Book book = bookRepository.findById(requestDto.getBookId()).orElseThrow(()-> new IllegalArgumentException("해당 도서를 찾을 수 없습니다."));

        //이미 장바구니에 있는 책인지 확인
        CartItem cartItem = cartItemRepository.findByUserAndBookId(user, book.getId())
                .orElse(null);

        if(cartItem == null){
            //처음 담는 경우
            cartItem = new CartItem(user, book, requestDto.getQuantity());
        } else {
            //이미 담겨져 있는 경우, 수량만 추가
            cartItem.updateQuantity(cartItem.getQuantity()+requestDto.getQuantity());
        }

        cartItemRepository.save(cartItem);
    }

    // 장바구니 조회
    public List<CartItemResponseDto> getCart(User user){
        List<CartItem> cartItems = cartItemRepository.findAllByUser(user);
        return cartItems.stream()
                .map(CartItemResponseDto::new)
                .collect(Collectors.toList());
    }

    // 장바구니 항목 삭제
    public void deleteCartItem(User user, Long cartItemId){
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(()-> new IllegalArgumentException("장바구니 항목에 존재하지 않습니다."));

        if(!cartItem.getUser().getId().equals(user.getId())){
            throw new IllegalArgumentException("본인의 장바구니 항목만 삭제할 수 있습니다.");
        }
        cartItemRepository.delete(cartItem);
    }
}
