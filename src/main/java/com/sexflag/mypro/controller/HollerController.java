package com.sexflag.mypro.controller;

import com.sexflag.mypro.pojo.PageBean;
import com.sexflag.mypro.pojo.Users;
import com.sexflag.mypro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HollerController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String sayHello(){
        List<Users> userlist = userService.selectAll();
        for (Users user:userlist
             ) {
            System.out.println(user.getUserName()+"-------"+user.getUserAddress());
        }
        System.out.println("======="+userService.selectUserById(1));

        return "huanying ni";
    }



    @GetMapping("/findAll/{page}/{size}")
    public PageBean<Users> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        //System.out.println("1111");
        PageBean<Users> pageList= userService.selectAllPage(page, size);
        return pageList;
    }


    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public Object login(@RequestParam("username") String username,@RequestParam("password") String password) {

        //获取当前的用户登陆信息
        Subject subject = SecurityUtils.getSubject();
        //定义返回信息
        Map<String,Object> result = new HashMap<>();
        result.put("status",200);
        result.put("msg","登陆成功");
        //信息验证
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println(subject.getPrincipal()+"-----"+token);
            result.put("user",subject.getPrincipal());
        }catch (UnknownAccountException e) {
            //用户名不存在
            result.put("status", "-1");
            result.put("msg", "用户名不存在");
        } catch (IncorrectCredentialsException e) {
            //密码错误
            result.put("status", "-1");
            result.put("msg", "用户名或密码错误");
        } catch (LockedAccountException e) {
            //账户被锁定
            result.put("status", "-1");
            result.put("msg", "账户被锁定");
        } catch (ExcessiveAttemptsException e) {
            //登录失败次数超过系统最大次数,请稍后重试
            result.put("status", "-1");
            result.put("msg", "登录失败次数超过系统最大次数,请稍后重试!");
        } catch (DisabledAccountException e) {
            //验证未通过,帐号已经禁止登录
            result.put("status", "-1");
            result.put("msg", "验证未通过,帐号已经禁止登录!");
        } catch (AuthenticationException e) {
            //出现其他异常
            result.put("status", "-2");
            result.put("msg", e.getMessage());
        }
        //System.out.println("登录成功========"+result.get("status"));
        return result;
    }
    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "当前用户无该页面的访问权限，无法进行访问";
    }


}














