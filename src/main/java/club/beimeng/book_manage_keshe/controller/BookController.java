package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.Book;
import club.beimeng.book_manage_keshe.service.BookService;
import club.beimeng.book_manage_keshe.utils.R;
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
 * @since 2022-07-07
 */
@RestController
@RequestMapping("/book_manage_keshe/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get_by_category_id")
    public R getByCategoryId(String categoryId){
        List<Book> bookList = bookService.getByCategoryId(categoryId);
        return R.ok().data("rows",bookList);
    }
}

