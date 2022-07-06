package club.beimeng.book_manage_keshe.entity.form;

import lombok.Data;

@Data
public class LoginForm {
    private String username;

    private String password;

    private String verifyCode;// 验证码
}
