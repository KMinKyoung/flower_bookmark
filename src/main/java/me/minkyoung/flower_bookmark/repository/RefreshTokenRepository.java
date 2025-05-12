package me.minkyoung.flower_bookmark.repository;

import me.minkyoung.flower_bookmark.token.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
