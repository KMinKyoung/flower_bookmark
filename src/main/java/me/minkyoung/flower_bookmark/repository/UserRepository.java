package me.minkyoung.flower_bookmark.repository;

import me.minkyoung.flower_bookmark.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId); //user_id를 통해 사용자 정보를 가져옴

}
