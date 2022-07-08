package club.beimeng.book_manage_keshe.service.impl;

import club.beimeng.book_manage_keshe.entity.User;
import club.beimeng.book_manage_keshe.mapper.UserMapper;
import club.beimeng.book_manage_keshe.service.UserService;
import club.beimeng.book_manage_keshe.utils.SaltUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 包龙
 * @since 2022-07-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getByUsername(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public User getByEmail(String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",email);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public void registerUser(String username, String encodedPassword, String salt) {
        // 判断用户是否存在
        if (getByUsername(username) != null){
            throw new RuntimeException("用户已存在");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setSalt(salt);

        save(user);
    }

    @Override
    public boolean verifyUser(String username, String password) {
        User user = getByUsername(username);
        if (user == null){
            return false;
        }
        String salt = user.getSalt();
        // 加密密码
        String encodedPassword = new Md5Hash(password,salt,21).toHex();
        return encodedPassword.equals(user.getPassword());
    }
}
