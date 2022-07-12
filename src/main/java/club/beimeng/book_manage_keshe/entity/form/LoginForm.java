package club.beimeng.book_manage_keshe.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
public class LoginForm {
    @ApiModelProperty("用户名/邮箱")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("验证码")
    private String verifyCode;// 验证码
}
