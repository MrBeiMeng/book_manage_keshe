package club.beimeng.book_manage_keshe.service;

import club.beimeng.book_manage_keshe.entity.Book;
import club.beimeng.book_manage_keshe.entity.form.BookForm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 蔡济声
 * @since 2022-07-07
 */
public interface BookService extends IService<Book> {

    List<Book> getByCategoryId(String categoryId);

    List<Book> recommendBook(int nums);

    List<Book> searchBook(String book_name, String content, String author);

    void saveBookForm(BookForm bookForm);
}
