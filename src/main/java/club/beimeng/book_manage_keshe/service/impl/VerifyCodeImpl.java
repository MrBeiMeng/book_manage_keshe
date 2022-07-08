package club.beimeng.book_manage_keshe.service.impl;

import club.beimeng.book_manage_keshe.entity.VerifyCode;
import club.beimeng.book_manage_keshe.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

@Service
public class VerifyCodeImpl implements VerifyCodeService {

    private final HashMap<String, VerifyCode> codeMap = new HashMap<>();
    private final long maxTime = 60000;

    @Override
    public String getCode(String email) {
        String str = "0123456789";
        int num = 4;
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < num; i++) {
            char c = str.charAt(new Random().nextInt(str.length()));
            code.append(c);
        }

        //验证码存到codeMap中
        codeMap.put(email, new VerifyCode(email, code.toString(), new Date()));

        return code.toString();
    }

    @Override
    public boolean verifyCode(String email, String code) {
        // todo 验证验证码
        Set<String> codeSet = codeMap.keySet();

        //当前时间
        Date date = new Date();
        long time = date.getTime();
        for (String s : codeSet) {
            if (time - codeMap.get(s).getCreate_time().getTime() <= maxTime && time - codeMap.get(s).getCreate_time().getTime() >=0) {
                return true;
            }else {
                codeMap.remove(s);
            }
        }
        return false;
    }
}
