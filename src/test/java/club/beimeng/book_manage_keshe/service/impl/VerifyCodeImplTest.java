package club.beimeng.book_manage_keshe.service.impl;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class VerifyCodeImplTest {

    @Test
    void getCode() {
        String str = "0123456789";
        int num = 4;
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < num; i++) {
            char c = str.charAt(new Random().nextInt(str.length()));
            code.append(c);
        }
        System.out.println(code);
    }

    @Test
    void verifyCode() {

    }
}