package me.minkyoung.flower_bookmark.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id 자동 증가
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 100)
    private String publisher;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock_quantity;

    @Lob //(Large Object)
    private String description;

    @Column(name = "image_url", length = 500)
    private String image_url;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<OrderItem> orderItems;

}
