package me.minkyoung.flower_bookmark.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String publisher;
    private String author;
    private Integer price;
    private Integer stock_quantity;
    private String image_url;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Builder
    public BookResponse(Long id, String title, String publisher, String author,
                        Integer price, Integer stock_quantity, String image_url,
                        String description, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.image_url = image_url;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
