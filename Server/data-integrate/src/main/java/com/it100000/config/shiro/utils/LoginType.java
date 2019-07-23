package com.it100000.config.shiro.utils;

/**
 * @author 杨新杰
 * @date 2019/7/1023:13
 */
public enum LoginType {
    /**
     * 默认登陆方式
     */
    DEFAULT("default"),
    /**
     * 短信验证码登陆
     */
    SMS_MSG("sms_msg"),
    /**
     * 管理员登陆
     */
    ADMIN("admin");

    /**
     * 登陆方式
     */
    private String type;

    LoginType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
