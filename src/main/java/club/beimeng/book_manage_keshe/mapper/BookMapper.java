package club.beimeng.book_manage_keshe.mapper;

import club.beimeng.book_manage_keshe.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 蔡济声
 * @since 2022-07-07
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    List<Book> getByCategoryId(String categoryId);

    List<Book> recommendBook(int nums);
}
