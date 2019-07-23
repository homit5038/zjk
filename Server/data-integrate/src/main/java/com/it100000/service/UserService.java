package com.it100000.service;

import com.it100000.entity.Role;
import com.it100000.entity.User;

import java.util.List;

/**
 * @author 杨新杰
 * @date 2019/7/229:22
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param s 用户名
     * @return com.it100000.entity.User
     * @author 杨新杰
     * @date 2019/7/22 9:30
     **/
    User queryUserInfoByUserName(String s);

    /**
     * 根据用户名查询用户角色信息
     *
     * @param s 用户名
     * @return java.util.List<com.it100000.entity.Role>
     * @author 杨新杰
     * @date 2019/7/22 10:11
     **/
    List<Role> queryUserRoleByUserName(String s);

    /**
     * 根据用户类型查询用户 为空查询所有
     *
     * @param type admin | patrol | null
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    List<User> queryUserByType(String type);

    /**
     * 插入用户
     *
     * @param user 用户实体类
     * @param type admin | patrol
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    int insertUser(User user, String type);

    /**
     * 删除用户
     *
     * @param uId 用户ID
     * @return 返回删除条目数
     * @author 杨新杰
     * @date 2019/7/23 11:20
     **/
    int deleteUser(String uId);

    /**
     * 删除用户
     *
     * @param uId    用户ID
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    String updatePwdByUserId(String uId, String oldPwd, String newPwd);
}
