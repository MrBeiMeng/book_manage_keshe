package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.form.LoginForm;
import club.beimeng.book_manage_keshe.service.UserService;
import club.beimeng.book_manage_keshe.shiro.JwtToken;
import club.beimeng.book_manage_keshe.utils.JwtUtils;
import club.beimeng.book_manage_keshe.utils.R;
import club.beimeng.book_manage_keshe.utils.SaltUtils;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
