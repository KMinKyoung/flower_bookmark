package me.minkyoung.flower_bookmark.config;

import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.domain.Role;
import me.minkyoung.flower_bookmark.entity.User;
import me.minkyoung.flower_bookmark.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void run(String... args){
        String adminId = "admin";

        if(userRepository.findByUserId(adminId).isEmpty()){
            User admin = new User(
                    adminId,
                    passwordEncoder.encode("1234"),
                    "admin@exampl.com",
                    "관리자",
                    Role.ROLE_ADMIN
            );
            userRepository.save(admin);
            System.out.println("관리자 계정 생성 완료:"+adminId);
        } else {
            System.out.println("관리자 계정이 이미 존재:" + adminId);
        }
    }
}
