package me.minkyoung.flower_bookmark.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.domain.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final UserDetailsService userDetailsService;
    @Value("${jwt.secret}")
    private String secretKey;

    private final long accessTokenValidity = 1000L * 60 * 30; //30분
    private final long refreshTokenValidity = 1000L * 60 * 60 * 24* 7; //7일

    //토큰 생성
    public String createAccessToken(String userId, Role role) {
        return createToken(userId,role, accessTokenValidity);
    }

    public String createRefreshToken(String userId, Role role) {
        return createToken(userId,role, refreshTokenValidity);
    }

    private String createToken(String userId, Role role, long validity) {
        Claims claims = Jwts.claims().setSubject(userId);

        //권한 추가
        claims.put("auth", role.name());
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validity))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 토큰에서 사용자 아이디 추출
    public String getUserId(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // 토큰 유효성 검증
    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        //권한 꺼내기
        String auth = claims.get("auth", String.class);
        if(auth==null){
            throw new RuntimeException("권한 정보가 없습니다.");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject());

        //권한 리스트로 변환
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(auth);

        //Authentication 객체 생성
        return new UsernamePasswordAuthenticationToken(userDetails,"",authorities);
    }
}
