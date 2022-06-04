package com.backend.rootbackend;

import com.backend.rootbackend.domain.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void passwordEncode() {
        //given
        String password = "123124";

        //when
        String encodePassword = passwordEncoder.encode(password);
        //then
        assertAll(
                () -> assertNotEquals(password, encodePassword),
                () -> assertTrue(passwordEncoder.matches(password, encodePassword))
        );
    }
}
