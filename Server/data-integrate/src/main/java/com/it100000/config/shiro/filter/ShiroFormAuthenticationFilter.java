package com.it100000.config.shiro.filter;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 杨新杰
 * @date 2019/7/2215:23
 */
public class ShiroFormAuthenticationFilter extends PermissionsAuthorizationFilter {
    /**
     * shiro认证perms资源失败后回调方法
     *
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //获取当前用户
        Subject subject = this.getSubject(httpServletRequest, httpServletResponse);
        //判断是否已经认证
        if (subject.getPrincipal() == null) {
            //没有认证则重定向到登录页面
            this.saveRequestAndRedirectToLogin(httpServletRequest, httpServletResponse);
        } else {
            //认证过了
            String requestedWith = httpServletRequest.getHeader("X-Requested-With");
            //如果是ajax返回指定格式数据
            if (!StringUtils.isEmpty(requestedWith) &&
                    StringUtils.equals(requestedWith, "XMLHttpRequest")) {
                //是ajax请求
                //设置响应头
                httpServletResponse.setContentType("text/json;charset=UTF-8");
                //返回json 数据，告知无权限
                httpServletResponse.getWriter().write("{\"success\":false,\"message\":\"对不起，你没有这个权限!\",\"errorCode\":-10001}");
            } else {//如果是普通请求进行重定向
                //不是ajax请求
                String unauthorizedUrl = this.getUnauthorizedUrl();
                if (!StringUtils.isEmpty(unauthorizedUrl)) {
                    WebUtils.issueRedirect(httpServletRequest, httpServletResponse, unauthorizedUrl);
                } else {
                    WebUtils.toHttp(httpServletResponse).sendError(401);
                }
            }

        }
        return false;
    }
}
