package com.hejz.shiro.controller;

import com.hejz.shiro.dto.RoleDto;
import com.hejz.shiro.dto.UserDto;
import com.hejz.shiro.service.LoginService;
import com.hejz.shiro.util.RestCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * login登陆
 *
 * @author 何建哲
 * @date 2018/11/19 14:32
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    //退出的时候是get请求，主要是用于退出
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    //post登录
    @PostMapping(value = "/login")
    public RestCode login(@RequestBody Map map) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                map.get("username").toString(),
                map.get("password").toString());
        usernamePasswordToken.setRememberMe(true);
        //进行验证，这里可以捕获异常，然后返回对应信息
        try {
            subject.login(usernamePasswordToken);
            return RestCode.ok();
        } catch (UnknownAccountException uae) {
            //username wasn't in the system, show them an error message?
            return RestCode.error("用户名不在系统中，显示错误信息");
        } catch (IncorrectCredentialsException ice) {
            //password didn't match, try again?
            return RestCode.error("密码不匹配，重试");
        } catch (LockedAccountException lae) {
            //account for that username is locked - can't login.  Show them a message?
            return RestCode.error("用户名已锁定-无法登录");
        } catch (AuthenticationException ae) {
            //unexpected condition - error?
            return RestCode.error("意外情况-错误");
        }

    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    //登出
    @RequestMapping(value = "/logout")
    public String logout() {
        return "logout";
    }

    //错误页面展示
    @PostMapping(value = "/error")
    public String error() {
        return "error ok!";
    }

    //数据初始化
    @PostMapping(value = "/addUser")
    public RestCode addUser(@Valid @RequestBody UserDto userDto) {
        try {
            return loginService.addUser(userDto);
        } catch (DataIntegrityViolationException e) {
            return RestCode.error("username已经存在");
        } catch (Exception e) {
            e.printStackTrace();
            return RestCode.error(e.getMessage());
        }
    }

    //角色初始化
    @PostMapping(value = "/addRole")
    public RestCode addRole(@Valid @RequestBody RoleDto roleDto) {
        try {
            return loginService.addRole(roleDto);
        } catch (Exception e) {
            return RestCode.error(e.getMessage());
        }
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create() {
        return "Create success!";
    }
}
