package me.minkyoung.flower_bookmark.service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.config.JwtTokenProvider;
import me.minkyoung.flower_bookmark.domain.Role;
import me.minkyoung.flower_bookmark.dto.SignupRequestDto;
import me.minkyoung.flower_bookmark.dto.TokenDto;
import me.minkyoung.flower_bookmark.dto.TokenRequestDto;
import me.minkyoung.flower_bookmark.entity.User;
import me.minkyoung.flower_bookmark.repository.RefreshTokenRepository;
import me.minkyoung.flower_bookmark.repository.UserRepository;
import me.minkyoung.flower_bookmark.token.RefreshToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;

    public TokenDto login(String userId, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userId, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findByUserId(userId).orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 사용자입니다."));
        //토큰 발급
        String accessToken = jwtTokenProvider.createAccessToken(user.getUserId(), user.getRole());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getUserId(), user.getRole());

        //리프렐시 토큰 저장
        RefreshToken refresh = new RefreshToken(userId, refreshToken);
        refreshTokenRepository.save(refresh);

        return new TokenDto(accessToken, refreshToken);
    }

    public TokenDto reissue(TokenRequestDto requestDto) {
        String refreshToken = requestDto.getRefreshToken();

        // 토큰 유효성 검증
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new RuntimeException("Invalid refresh token");
        }

        // 유저 아이디 추출
        String userId = jwtTokenProvider.getUserId(refreshToken);

        //DB에 저장된 리프레시 토큰과 비교
        RefreshToken savedToken = refreshTokenRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("RefreshToken not found"));

        if (!savedToken.getToken().equals(refreshToken)) {
            throw new RuntimeException("Token mismatch");
        }

        Role role = userRepository.findByUserId(userId)
                .orElseThrow(()-> new RuntimeException("유저를 찾을 수 없습니다.")).getRole();

        //새 토큰 발급
        String newAccess = jwtTokenProvider.createAccessToken(userId,role);
        String newRefresh = jwtTokenProvider.createRefreshToken(userId,role);

        //리프레시 토큰 갱신
        refreshTokenRepository.save(new RefreshToken(userId, newRefresh));

        return new TokenDto(newAccess, newRefresh);
    }

    public void signup(SignupRequestDto requestDto) {
        // 이미 존재하는 유저인지 확인
        if (userRepository.findByUserId(requestDto.getUserId()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        //비밀번호 인코딩 후 user 객체 생성
        User user = new User();
        user.setUserId(requestDto.getUserId());
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setName(requestDto.getName());
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);
    }
}
