package club.beimeng.book_manage_keshe.service.impl;

import club.beimeng.book_manage_keshe.entity.VerifyCode;
import club.beimeng.book_manage_keshe.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

//@Service
public class VerifyCodeImpl implements VerifyCodeService {

    private final HashMap<String, VerifyCode> codeMap = new HashMap<>();

    @Override
    public String getCode(String email) {
        String str = "0123456789";
        int num = 4;
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < num; i++) {
            char c = str.charAt(new Random().nextInt(str.length()));
            code.append(c);
        }

        codeMap.put(email,new VerifyCode(email,code.toString(),new Date()));
        return code.toString();
    }

    @Override
    public boolean verifyCode(String email, String code) {
        // todo 验证验证码

        return false;
    }
}
