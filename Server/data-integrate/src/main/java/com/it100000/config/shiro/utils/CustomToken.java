package com.it100000.config.shiro.utils;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 短信登陆的TOKEN
 *
 * @author 杨新杰
 * @date 2019/7/1023:17
 */
public class CustomToken extends UsernamePasswordToken {

    private String loginType;

    public CustomToken(final String username, final String password, String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
