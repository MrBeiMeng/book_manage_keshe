package club.beimeng.book_manage_keshe.service;

import club.beimeng.book_manage_keshe.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 包龙
 * @since 2022-07-06
 */
public interface UserService extends IService<User> {

    void registerUser(String username, String encodedPassword, String salt);

    boolean verifyUser(String username, String password);

    User getByUsername(String username);

    User getByEmail(String email);
}
