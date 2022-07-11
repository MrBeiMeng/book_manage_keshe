package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.User;
import club.beimeng.book_manage_keshe.entity.form.LoginForm;
import club.beimeng.book_manage_keshe.service.EmailService;
import club.beimeng.book_manage_keshe.service.UserService;
import club.beimeng.book_manage_keshe.service.VerifyCodeService;
import club.beimeng.book_manage_keshe.shiro.JwtToken;
import club.beimeng.book_manage_keshe.utils.EmailUtils;
import club.beimeng.book_manage_keshe.utils.JwtUtils;
import club.beimeng.book_manage_keshe.utils.R;
import club.beimeng.book_manage_keshe.utils.SaltUtils;
import io.swagger.annotations.Api;
import net.bytebuddy.asm.Advice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 包龙
 * @since 2022-07-06
 */
@Api
@RestController
@RequestMapping("/book_manage_keshe/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private VerifyCodeService verifyCodeService;

    @PostMapping("login")
    public R login(@RequestBody LoginForm loginForm) {
        User user = EmailUtils.isEmail(loginForm.getUsername()) ?
                userService.getByEmail(loginForm.getUsername()) :
                userService.getByUsername(loginForm.getUsername());

        if (!userService.verifyUser(user.getUsername(), loginForm.getPassword())) {
            return R.error().message("账号或密码错误.");
        }

        if (!verifyCodeService.verifyCode(user.getEmail(), loginForm.getVerifyCode())) {

            return R.error().message("验证码错误.");
        }

        String jwtToken = JwtUtils.generate(user.getUsername());
        Subject subject = SecurityUtils.getSubject();
        subject.login(new JwtToken(jwtToken));

        return R.ok().data("token", jwtToken);
    }

    @GetMapping("get_verify_code")
    public R getVerifyCode(String toEmail) {

        //判断是否是邮箱
        if (!EmailUtils.isEmail(toEmail)) {
            toEmail = userService.getByUsername(toEmail).getEmail();
        }

        //拿到验证码
        String verifyCode = verifyCodeService.getCode(toEmail);
        // 检验toEmail 合法性
        emailService.sendSimpleMail("1192384722@qq.com", toEmail, "请查收您的验证码", verifyCode);
        return R.ok().message("发送成功").data("emailNumber",EmailUtils.blur(toEmail));
    }

    @PostMapping("register")
    public R register(@RequestBody LoginForm loginForm) {
        String salt = SaltUtils.getSalt(8);
        // 加密密码
        String encodedPassword = new Md5Hash(loginForm.getPassword(), salt, 21).toHex();
        // 保存用户
        userService.registerUser(loginForm.getUsername(), encodedPassword, salt);
        return R.ok();
    }

    @PostMapping("logout")
    public R logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.ok();
    }

    @GetMapping("get_info")
    public R getUser() {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        String username = JwtUtils.getUsername(principal);
        User user = userService.getByUsername(username);

        // const { roles, name, avatar } = data 前端需要至少这三个信息
        return R.ok().data("roles", user.getRole()).data("name",user.getRealName()).data("avatar",user.getAvatar()).data("userDetail",user);
    }
}
