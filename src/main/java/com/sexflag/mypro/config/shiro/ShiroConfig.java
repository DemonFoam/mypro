package com.sexflag.mypro.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //3.shiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤容器
        /*
            anon:  无需认证即可访问
            authc: 必须登录才可访问
            user： 必须拥有 记住我 功能才可以使用
            perms: 拥有对某个资源的权限才可以访问
            roles： 拥有某个角色权限才可以访问
         */
        //设置拦截
        Map<String,String> filterMap = new HashMap<>();
        //anon表示可以匿名访问
        filterMap.put("/index", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/static/**", "anon");

        filterMap.put("/*","authc");

        bean.setFilterChainDefinitionMap(filterMap);
        //设置未授权的请求
        bean.setUnauthorizedUrl("/unauthorized");
        //设置登录的请求  去访问登录页
        bean.setLoginUrl("/toLogin");
        return bean;
    }

    //2.配置安全管理 SecurityManager
    @Bean(name="securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }

    //1.创建Realm对象
    @Bean(name="shiroRealm")
    public ShiroRealm shiroRealm(){
        return new ShiroRealm();
    }

}
