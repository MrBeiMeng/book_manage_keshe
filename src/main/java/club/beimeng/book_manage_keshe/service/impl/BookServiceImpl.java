package club.beimeng.book_manage_keshe.service.impl;

import club.beimeng.book_manage_keshe.entity.Book;
import club.beimeng.book_manage_keshe.entity.form.BookForm;
import club.beimeng.book_manage_keshe.mapper.BookMapper;
import club.beimeng.book_manage_keshe.service.BookService;
import club.beimeng.book_manage_keshe.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 蔡济声
 * @since 2022-07-07
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> getByCategoryId(String categoryId) {
        return bookMapper.getByCategoryId(categoryId);
    }

    @Override
    public List<Book> recommendBook(int nums) {
        return bookMapper.recommendBook(nums);
    }

    @Override
    public List<Book> searchBook(String bookName, String content, String author) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();

        if (bookName != null){
            queryWrapper.eq("book_name",bookName);
        }
        if (author != null){
            queryWrapper.eq("author",author);
        }
        if (content != null){
            queryWrapper.like("content",content);
        }
        queryWrapper.eq("status" ,2);
        return bookMapper.selectList(queryWrapper);
    }

    @Override
    public void saveBookForm(BookForm bookForm) {
        Book book = new Book();
        BeanUtils.copyProperties(book,bookForm);
        save(book);
    }
}
