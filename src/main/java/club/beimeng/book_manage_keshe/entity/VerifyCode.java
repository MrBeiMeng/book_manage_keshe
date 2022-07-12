package club.beimeng.book_manage_keshe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("验证码对象")
public class VerifyCode {
    @ApiModelProperty(value = "收件人")
    String toEmail; // 这个验证码对应的邮箱账号

    @ApiModelProperty(value = "验证码")
    String code; // 验证码内容

    @ApiModelProperty(value = "创建时间")
    Date create_time; // 验证码生成时间
}
