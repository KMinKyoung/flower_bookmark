package me.minkyoung.flower_bookmark.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id 자동 증가
    private int id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 100)
    private String publisher;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock_quantity;


    // 이미지 url,생성일시, 업데이트 일시 칠드 추가해야함
}
