package me.minkyoung.flower_bookmark.controller;

import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.dto.SignupRequestDto;
import me.minkyoung.flower_bookmark.dto.TokenDto;
import me.minkyoung.flower_bookmark.dto.TokenRequestDto;
import me.minkyoung.flower_bookmark.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<TokenDto> login(@RequestBody Map<String, String> loginInfo) {
        String userId = loginInfo.get("userId");
        String password = loginInfo.get("password");

        TokenDto tokenDto = authService.login(userId, password);
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequestDto requestDto) {
        authService.signup(requestDto);
        return ResponseEntity.ok("회원가입 성공!");
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenDto> refresh(@RequestBody TokenRequestDto requestDto) {
        TokenDto tokens = authService.reissue(requestDto);
        return ResponseEntity.ok(tokens);
    }


}
