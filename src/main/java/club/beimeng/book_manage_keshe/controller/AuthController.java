package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.User;
import club.beimeng.book_manage_keshe.entity.form.LoginForm;
import club.beimeng.book_manage_keshe.service.EmailService;
import club.beimeng.book_manage_keshe.service.UserService;
import club.beimeng.book_manage_keshe.shiro.JwtToken;
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
 *  前端控制器
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

    @PostMapping("login")
    public R login(LoginForm loginForm){
        if (!userService.verifyUser(loginForm.getUsername(),loginForm.getPassword())){
            return R.error().message("账号或密码错误.");
        }

        String jwtToken = JwtUtils.generate(loginForm.getUsername());
        Subject subject = SecurityUtils.getSubject();
        subject.login(new JwtToken(jwtToken));

        return R.ok().data("token",jwtToken);
    }

    @GetMapping("get_verify_code")
    public R getVerifyCode(String toEmail){
        // 检验toEmail 合法性
        emailService.sendSimpleMail("1192384722@qq.com",toEmail,"测试邮件","热爱可抵岁月漫长。");
        return R.ok().message("发送成功");
    }

    @PostMapping("register")
    public R register(@RequestBody LoginForm loginForm){
        String salt = SaltUtils.getSalt(8);
        // 加密密码
        String encodedPassword = new Md5Hash(loginForm.getPassword(),salt,21).toHex();
        // 保存用户
        userService.registerUser(loginForm.getUsername(),encodedPassword,salt);
        return R.ok();
    }

    @PostMapping("logout")
    public R logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.ok();
    }

    @GetMapping("get_info")
    public R getUser(){
        Subject subject = SecurityUtils.getSubject();
        String principal =  (String) subject.getPrincipal();
        String username = JwtUtils.getUsername(principal);
        User user = userService.getByUsername(username);
        return R.ok().data("rows",user);
    }
}
