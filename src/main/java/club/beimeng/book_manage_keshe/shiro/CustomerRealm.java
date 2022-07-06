package club.beimeng.book_manage_keshe.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomerRealm extends AuthorizingRealm {
    //处理授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("---------------------------");
        // 获取身份信息
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        System.out.println("调用授权验证: "+primaryPrincipal);
        //根据主身份信息获取角色 和 权限信息

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addRole("admin");

        return simpleAuthorizationInfo;
//        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
//        User user = userService.findRolesByUserName(primaryPrincipal);
//        //授权角色信息
//        if(!CollectionUtils.isEmpty(user.getRoles())){
//            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//            user.getRoles().forEach(role->{
//                simpleAuthorizationInfo.addRole(role.getName());
//                //权限信息
//                List<Perms> perms = userService.findPermsByRoleId(role.getId());
//                if(!CollectionUtils.isEmpty(perms)){
//                    perms.forEach(perm->{
//                        simpleAuthorizationInfo.addStringPermission(perm.getName());
//                    });
//                }
//            });
//            return simpleAuthorizationInfo;
//        }
//        return null;
    }


    //处理认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("==========================");
        String principal = (String) token.getPrincipal();
        if("xiaochen".equals(principal)){
            return new SimpleAuthenticationInfo(principal,"123",this.getName());
        }
        return null;

    }
}