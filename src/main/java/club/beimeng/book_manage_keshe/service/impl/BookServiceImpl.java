package club.beimeng.book_manage_keshe.service.impl;

import club.beimeng.book_manage_keshe.entity.Book;
import club.beimeng.book_manage_keshe.mapper.BookMapper;
import club.beimeng.book_manage_keshe.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
