package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.Application;
import club.beimeng.book_manage_keshe.entity.User;
import club.beimeng.book_manage_keshe.service.ApplicationService;
import club.beimeng.book_manage_keshe.service.UserService;
import club.beimeng.book_manage_keshe.utils.JwtUtils;
import club.beimeng.book_manage_keshe.utils.R;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 蔡济声
 * @since 2022-07-13
 */
@RestController
@RequestMapping("/book_manage_keshe/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserService userService;

    @PostMapping("/add_application")
    public R addApplication(@RequestBody Application application){
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        String username = JwtUtils.getUsername(principal);
        User user = userService.getByUsername(username);
        application.setUserId(user.getId());

        return R.ok().data("rows",applicationService.save(application));
    }
    @GetMapping("/get_all_application")
    public R getAllApplication(){
        return R.ok().data("rows",applicationService.list());
    }

    @PostMapping("/save_or_update_application")
    public R saveOrUpdateApplication(@RequestBody @ApiParam("更新或添加用户的实体类") Application application) {
        if (!StringUtils.isEmpty(application.getId())){
            applicationService.updateById(application);
            return R.ok().message("更新成功");
        }else {
            applicationService.save(application);
            return R.ok().message("添加成功成功");
        }
    }

    @PostMapping("delete_these_applications")
    public R deleteApplication(@ApiParam("删除图书的编号") @RequestBody ArrayList<String> ids){
        applicationService.removeByIds(ids);
        return R.ok().message("删除成功");
    }

}

