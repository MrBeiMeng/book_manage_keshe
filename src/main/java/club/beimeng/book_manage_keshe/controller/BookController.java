package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.Book;
import club.beimeng.book_manage_keshe.entity.form.SearchForm;
import club.beimeng.book_manage_keshe.service.BookService;
import club.beimeng.book_manage_keshe.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
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

    @GetMapping("get_by_category_id")
    public R getByCategoryId(String categoryId) {
        List<Book> bookList = bookService.getByCategoryId(categoryId);
        return R.ok().data("rows", bookList);
    }

    @GetMapping("get_all_book")
    public R getAllBook() {
        return R.ok().data("rows", bookService.list());
    }

    @PostMapping("update_book_by_id")
    public R updateBookById(Book book) {
        bookService.updateById(book);
        return R.ok().message("更新成功");
    }

    @PostMapping("save_book")
    public R saveBook(Book book){
        bookService.save(book);
        return R.ok().message("保存成功");
    }

    @DeleteMapping("delete_book")
    public R deleteBook(int id){
        bookService.removeById(id);
        return R.ok().message("删除成功");
    }

    @GetMapping("recommend_book")
    public R recommendBook(int nums) {
        return R.ok().data("rows", bookService.recommendBook(nums));
    }

    @GetMapping("search_book")
    public R searchBook(String book_name, String content, String author) {
        List<Book> bookList = bookService.searchBook(book_name,content,author);
        return R.ok().data("rows",bookList);
    }
}

