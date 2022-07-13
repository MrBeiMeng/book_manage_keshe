package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.Book;
import club.beimeng.book_manage_keshe.entity.User;
import club.beimeng.book_manage_keshe.service.UserService;
import club.beimeng.book_manage_keshe.utils.R;
import club.beimeng.book_manage_keshe.utils.SaltUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
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
@RequestMapping("/book_manage_keshe/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("单纯一个测试方法")
    @GetMapping("test")
    public R test(){
        System.out.println("hello world");
        return R.ok();
    }

    @GetMapping("/get_all_user")
    public R getAllUser(){
        return R.ok().data("rows",userService.list());
    }

    @PostMapping("/save_or_update_user")
    public R saveOrUpdateBook(@RequestBody @ApiParam("更新或添加用户的实体类") User user) {
        if (!StringUtils.isEmpty(user.getId())){
            userService.updateById(user);
            return R.ok().message("更新成功");
        }else {
            String salt = SaltUtils.getSalt(8);
            // 加密密码
            String encodedPassword = new Md5Hash(user.getPassword(), salt, 21).toHex();

            user.setPassword(encodedPassword);
            user.setSalt(salt);
            userService.save(user);
            return R.ok().message("添加成功成功");
        }
    }

    @DeleteMapping("delete_user_by_id")
    public R deleteBook(@ApiParam("删除用户的编号") String id){
        userService.removeById(id);
        return R.ok().message("删除成功");
    }

}

