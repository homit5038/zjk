package com.it100000.controller.common;

import com.it100000.config.jwt.JwtUtil;
import com.it100000.dto.BasicResult;
import com.it100000.entity.User;
import com.it100000.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * @author 杨新杰
 * @date 2019/7/1023:51
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/common")
public class UserCommonController {

    @Resource
    private UserService userService;

    /**
     * 通用登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回登陆结果
     * @author 杨新杰
     * @date 2019/7/22 11:23
     **/
    @RequestMapping("/login")
    public BasicResult login(@NotBlank(message = "用户名不能为空") String username,
                             @NotBlank(message = "密码不能为空") String password) {
        // 获取用户是否存在
        User u = userService.queryUserInfoByUserName(username);
        if (u == null) {
            return new BasicResult(BasicResult.SUCCESS, null, "用户不存在");
        }
        String salt = u.getSalt();
        // 加密用户密码并判断密码
        String md5Pwd = new SimpleHash("MD5", password, salt, 10).toString();
        if (!u.getPassword().equals(md5Pwd)) {
            throw new IncorrectCredentialsException("密码错误");
        }
        return new BasicResult(BasicResult.SUCCESS, JwtUtil.sign(username, u.getPassword()), "登陆成功");
    }


    /**
     * 通用退出
     *
     * @return 返回登陆结果
     * @author 杨新杰
     * @date 2019/7/22 11:23
     **/
    @RequestMapping("/logout")
    public BasicResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BasicResult.successResult();
    }


}
