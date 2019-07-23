package com.it100000.exception;

import com.it100000.dto.BasicResult;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.HostUnauthorizedException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * shiro异常处理
 *
 * @author 杨新杰
 * @date 2019/7/11 15:40
 */
@RestControllerAdvice
public class ShiroException {

    //////////////////////////// 认证类

    /**
     * 认证异常
     */
    @ExceptionHandler(AuthenticationException.class)
    public BasicResult authenticationException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "认证异常");
    }

    /**
     * 账户异常
     */
    @ExceptionHandler(AccountException.class)
    public BasicResult accountException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "账户异常");
    }

    /**
     * 在别处已经登陆
     */
    @ExceptionHandler(ConcurrentAccessException.class)
    public BasicResult concurrentAccessException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "在别处已经登陆");
    }

    /**
     * 账户已被禁用
     */
    @ExceptionHandler(DisabledAccountException.class)
    public BasicResult disabledAccountException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "账户已被禁用");
    }

    /**
     * 账户被锁定
     */
    @ExceptionHandler(LockedAccountException.class)
    public BasicResult lockedAccountException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "账户被锁定");
    }

    /**
     * 登陆次数过多
     */
    @ExceptionHandler(ExcessiveAttemptsException.class)
    public BasicResult excessiveAttemptsException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "登陆次数过多,请稍后重试");
    }

    /**
     * 用户名不存在
     */
    @ExceptionHandler(UnknownAccountException.class)
    public BasicResult unknownAccountException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "用户名不存在");
    }

    /**
     * 凭证异常
     */
    @ExceptionHandler(CredentialsException.class)
    public BasicResult credentialsException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "凭证异常");
    }


    /**
     * 凭证过期
     */
    @ExceptionHandler(ExpiredCredentialsException.class)
    public BasicResult expiredCredentialsException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "凭证过期");
    }


    /**
     * 凭证错误
     */
    @ExceptionHandler(IncorrectCredentialsException.class)
    public BasicResult incorrectCredentialsException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "凭证错误");
    }


    /**
     * 令牌异常
     */
    @ExceptionHandler(UnsupportedTokenException.class)
    public BasicResult unsupportedTokenException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "令牌异常");
    }


    ///////////////////// 授权类

    /**
     * 权限异常
     */
    @ExceptionHandler(AuthorizationException.class)
    public BasicResult authorizationException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "权限异常");
    }

    /**
     * 用户未登录
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public BasicResult unauthenticatedException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "用户未登录");
    }

    /**
     * 无权访问
     */
    @ExceptionHandler(UnauthorizedException.class)
    public BasicResult unauthorizedException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "无权访问");
    }

    /**
     * 访问异常
     */
    @ExceptionHandler(HostUnauthorizedException.class)
    public BasicResult hostUnauthorizedException(HttpServletRequest request, Exception ex) {
        return new BasicResult(BasicResult.FAILURE, ex.getMessage(), "访问异常");
    }


}
