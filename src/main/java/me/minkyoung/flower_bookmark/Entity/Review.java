package me.minkyoung.flower_bookmark.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 사용자와 m:1
    @JoinColumn(name ="user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) //책과 m:1
    @JoinColumn(name = "book_id", nullable = false)
    Book book;

    @Column(nullable = false, columnDefinition = "Text")
    private String content;

    @Column(nullable = false)
    private int rating;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
