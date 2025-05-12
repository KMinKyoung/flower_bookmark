package me.minkyoung.flower_bookmark.service;

import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.entity.User;
import me.minkyoung.flower_bookmark.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    //사용자 이름(user_id)로 사용자의 정보를 가져오는 메서드
    @Override
    public User loadUserByUsername(String user_id){

        return  userRepository.findByUserId(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }
}
