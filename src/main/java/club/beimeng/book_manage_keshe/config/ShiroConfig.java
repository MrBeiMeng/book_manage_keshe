package club.beimeng.book_manage_keshe.config;

import club.beimeng.book_manage_keshe.filter.CommonFilter;
import club.beimeng.book_manage_keshe.filter.JwtFilter;
import club.beimeng.book_manage_keshe.shiro.CustomerRealm;
import club.beimeng.book_manage_keshe.shiro.JwtDefaultSubjectFactory;
import club.beimeng.book_manage_keshe.shiro.JwtRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //三大核心对象：Subject、SecurityManager、Realm

    //告诉shiro不创建内置的session
    @Bean
    public SubjectFactory subjectFactory(){
        return new JwtDefaultSubjectFactory();
    }


    //3、ShiroFilterFactoryBean->Subject subject是用户主题，进入到securitymanager中
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //关联securityManager
        bean.setSecurityManager(getDefaultWebSecurityManager());
        //添加内置过滤器
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("anon",new CommonFilter());
        filterMap.put("jwt",new JwtFilter());
        bean.setFilters(filterMap);
        //添加拦截器，对路由进行限制
        Map<String, String> filterRuleMap = new LinkedHashMap<>();
        /*
            anon:无需认证可以直接访问
            auth:必须认证才能访问
            user:必须拥有 记住我功能才能用
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        filterRuleMap.put("/book_manage_keshe/auth/login","anon");
        filterRuleMap.put("/book_manage_keshe/auth/register","anon");
        filterRuleMap.put("/book_manage_keshe/auth/get_verify_code","anon");
        // 图书相关
        filterRuleMap.put("/book_manage_keshe/book/search_book","anon");
        filterRuleMap.put("/book_manage_keshe/book/recommend_book","anon");
        //放行Swagger2页面，需要放行这些
        filterRuleMap.put("/swagger-ui/index.html","anon");
        filterRuleMap.put("/swagger-ui/*","anon");
        filterRuleMap.put("/swagger/**","anon");
        filterRuleMap.put("/webjars/**", "anon");
        filterRuleMap.put("/swagger-resources/**","anon");
        filterRuleMap.put("/v3/**","anon");
        filterRuleMap.put("/static/**", "anon");

        filterRuleMap.put("/**","jwt");
        bean.setFilterChainDefinitionMap(filterRuleMap);
        return bean;
    }

    //2、DefaultWebSecurityManager->SecurityManager 管理所有用户，利用realm完成数据连接
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(realm());
        return securityManager;
    }


    //1、Realm->Realm 需要自定义一个Realm用于存储数据，这里使用jwtRealm
    @Bean
    public Realm realm() {
        return new JwtRealm();
    }
}
