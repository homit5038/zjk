package com.it100000.controller.common;

import com.it100000.dto.BasicResult;
import com.it100000.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author 杨新杰
 * @date 2019/7/1023:51
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/common")
public class UserCommonController {

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
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,true);
        subject.login(token);
        log.info("用户:" + username +"登陆,登陆状态:" + subject.isAuthenticated());
        // 设置返回的信息,把密码和salt设置为空
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        user.setPassword(null);
        user.setSalt(null);
        return BasicResult.successResult(user);
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
