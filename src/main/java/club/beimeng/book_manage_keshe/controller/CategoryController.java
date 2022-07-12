package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.Book;
import club.beimeng.book_manage_keshe.service.CategoryService;
import club.beimeng.book_manage_keshe.utils.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 蔡济声
 * @since 2022-07-09
 */
@RestController
@RequestMapping("/book_manage_keshe/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("获取分类列表")
    @GetMapping("get_all_category")
    public R getAllCategory(){
        return R.ok().data("rows",categoryService.list());
    }
}

