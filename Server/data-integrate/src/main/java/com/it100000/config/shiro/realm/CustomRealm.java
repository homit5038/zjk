package com.it100000.config.shiro.realm;

import com.it100000.config.jwt.JwtToken;
import com.it100000.config.jwt.JwtUtil;
import com.it100000.entity.Role;
import com.it100000.entity.User;
import com.it100000.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 杨新杰
 * @date 2019/7/1023:36
 */
public class CustomRealm extends AuthorizingRealm {

    @Lazy
    @Resource
    private UserService userService;

    /**
     * 显式设置token为自定义的token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String token = (String)principals.getPrimaryPrincipal();
        String uname = JwtUtil.getUsername(token);

        Set<String> roles = getRolesByUsername(uname);
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        authenticationInfo.setRoles(roles);
        // 无需权限,只用角色控制,所以这里可以直接返回null
        authenticationInfo.setStringPermissions(null);
        return authenticationInfo;
    }

    /**
     * 获取用户角色
     *
     * @param uname 用户名
     * @return java.util.Set<java.lang.String>
     * @author 杨新杰
     * @date 2019/7/22 10:22
     **/
    private Set<String> getRolesByUsername(String uname) {
        List<Role> roles = userService.queryUserRoleByUserName(uname);
        if (roles.size() <= 0) {
            return null;
        }
        Set<String> roleSet = new HashSet<>();
        for (Role role : roles) {
            roleSet.add(role.getName());
        }
        return roleSet;
    }

    /**
     * 获取登陆信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String uToken    = (String) token.getCredentials();
        String username  = JwtUtil.getUsername(uToken);
        User user        = userService.queryUserInfoByUserName(username);
        if (user == null){
            throw new UnknownAccountException("用户不存在");
        }
        if (!JwtUtil.verify(uToken,username,user.getPassword())){
            throw new CredentialsException("密码错误");
        }
        return new SimpleAuthenticationInfo(uToken,uToken,getName());
    }

}
