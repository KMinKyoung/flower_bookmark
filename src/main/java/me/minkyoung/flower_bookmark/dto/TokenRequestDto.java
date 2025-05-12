package me.minkyoung.flower_bookmark.dto;

import lombok.Getter;

@Getter
public class TokenRequestDto { //재발급 요청 Dto
    private String refreshToken;
}
