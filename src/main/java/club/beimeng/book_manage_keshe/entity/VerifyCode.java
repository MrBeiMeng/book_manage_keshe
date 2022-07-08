package club.beimeng.book_manage_keshe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyCode {
    String toEmail; // 这个验证码对应的邮箱账号

    String code; // 验证码内容

    Date create_time; // 验证码生成时间
}
