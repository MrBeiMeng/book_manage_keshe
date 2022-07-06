package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.utils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/book_manage_keshe/user")
public class UserController {

    @GetMapping("test")
    public R test(){
        System.out.println("hello world");
        return R.ok();
    }
}

