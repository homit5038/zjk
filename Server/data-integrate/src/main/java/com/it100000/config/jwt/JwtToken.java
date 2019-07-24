package com.it100000.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 杨新杰
 * @date 2019/7/2420:29
 */
public class JwtToken implements AuthenticationToken{

    /** token */
    private String token;


    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }


    @Override
    public Object getCredentials() {
        return token;
    }
}
