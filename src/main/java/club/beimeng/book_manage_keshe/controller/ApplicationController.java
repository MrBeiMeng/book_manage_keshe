package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.Application;
import club.beimeng.book_manage_keshe.service.ApplicationService;
import club.beimeng.book_manage_keshe.utils.R;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("delete_application_by_id")
    public R deleteApplication(@ApiParam("删除用户的编号") String id){
        applicationService.removeById(id);
        return R.ok().message("删除成功");
    }

}

