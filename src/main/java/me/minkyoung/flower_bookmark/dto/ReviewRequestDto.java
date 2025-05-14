package me.minkyoung.flower_bookmark.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDto {
    private String content;
    private int rating; //1~5
}
