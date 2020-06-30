package com.sexflag.mypro.config.shiro;

import com.sexflag.mypro.dao.SysUserMapper;
import com.sexflag.mypro.pojo.Msg;
import com.sexflag.mypro.pojo.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 自定义的realm
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserMapper sysUserMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权======》");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //给aa用户授权bb访问权限
        info.addStringPermission("aa:bb");
        //拿到当前登录的用户对象
        Subject subject = SecurityUtils.getSubject();
        //User currentUser =subject.getPrincipal()  拿到user对象
        subject.getPrincipal();
        //添加user用户拥有的权限
        //info.addStringPermission(currentUser.get());
        //可以进行加密  MD5  MD5盐值加密
//        Object principal;//账号
//        Object credentials ;//密码
//        Object credentialsSalt = ByteSource.Util.bytes(currentUser.username);//盐值
//        String realmName = getName();
//        info = new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);

        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证======》");

        UsernamePasswordToken userToken =(UsernamePasswordToken) token;
        //连接数据库查询用户信息
        //通过userToken.getUsername()获取前端传入的账户名    进行判断
        SysUser user=sysUserMapper.selectByUsername(userToken.getUsername());
        if(user!=null){
        if(userToken.getUsername().equals(user.getUserName())){
            //密码认证，shiro做~   可以把查出的用户放入第一个参数
            return new SimpleAuthenticationInfo(user,user.getPassWord(),"");
        }
        }
        System.out.println("认证完成");
        return null;
    }
}
