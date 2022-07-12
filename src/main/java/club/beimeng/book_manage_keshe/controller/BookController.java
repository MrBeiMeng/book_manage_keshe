package club.beimeng.book_manage_keshe.controller;


import club.beimeng.book_manage_keshe.entity.Book;
import club.beimeng.book_manage_keshe.entity.form.BookForm;
import club.beimeng.book_manage_keshe.entity.form.SearchForm;
import club.beimeng.book_manage_keshe.service.BookService;
import club.beimeng.book_manage_keshe.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api
@RestController
@RequestMapping("/book_manage_keshe/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("根据书的类别返回分类列表")
    @GetMapping("get_by_category_id")
    public R getByCategoryId(@ApiParam("图书种类的编号") String categoryId) {
        List<Book> bookList = bookService.getByCategoryId(categoryId);
        return R.ok().data("rows", bookList);
    }

    @ApiOperation("查询所有书籍")
    @GetMapping("get_all_book")
    public R getAllBook() {
        return R.ok().data("rows", bookService.list());
    }

    @ApiOperation("更新图书")
    @PostMapping("update_book_by_id")
    public R updateBookById(@RequestBody @ApiParam("更新图书的实体类") Book book) {
        bookService.updateById(book);
        return R.ok().message("更新成功");
    }

    @ApiOperation("保存图书")
    @PostMapping("save_book")
    public R saveBookForm(@RequestBody @ApiParam("保存图书的表单") BookForm bookForm){
        bookService.saveBookForm(bookForm);
        return R.ok().message("保存成功");
    }

    @ApiOperation("删除图书")
    @DeleteMapping("delete_book")
    public R deleteBook(@ApiParam("删除图书的编号") int id){
        bookService.removeById(id);
        return R.ok().message("删除成功");
    }

    @ApiOperation("推荐图书")
    @GetMapping("recommend_book")
    public R recommendBook(@ApiParam("推荐图书数量") Integer nums) {
        return R.ok().data("rows", bookService.recommendBook(nums));
    }

    @ApiOperation("搜索图书")
    @GetMapping("search_book")
    public R searchBook(@ApiParam("搜索图书的参数，可以是用户名,作者，内容") SearchForm searchForm) {
        List<Book> bookList = bookService.searchBook(searchForm.getBookName(),searchForm.getContent(),searchForm.getAuthor());
        return R.ok().data("rows",bookList);
    }
}

