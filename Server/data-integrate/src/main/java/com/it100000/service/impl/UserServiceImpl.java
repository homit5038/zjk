package com.it100000.service.impl;

import com.it100000.dao.RoleMapper;
import com.it100000.dao.UserMapper;
import com.it100000.dao.UserToRoleMapper;
import com.it100000.entity.Role;
import com.it100000.entity.User;
import com.it100000.entity.UserToRole;
import com.it100000.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨新杰
 * @date 2019/7/229:22
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserToRoleMapper userToRoleMapper;

    @Resource
    private RoleMapper roleMapper;

    /**
     * 根据用户名查询用户信息
     *
     * @param s 用户名
     * @return com.it100000.entity.User
     * @author 杨新杰
     * @date 2019/7/22 9:30
     **/
    @Override
    public User queryUserInfoByUserName(String s) {
        Example e = new Example(User.class);
        e.createCriteria().andCondition("username=", s);
        return userMapper.selectOneByExample(e);
    }

    /**
     * 根据用户名查询用户角色信息
     *
     * @param s 用户名
     * @return java.util.List<com.it100000.entity.Role>
     * @author 杨新杰
     * @date 2019/7/22 10:11
     **/
    @Override
    public List<Role> queryUserRoleByUserName(String s) {
        return userMapper.selectRolesByUserName(s);
    }

    /**
     * 根据用户类型查询用户 为空查询所有
     *
     * @param type admin | patrol | null
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    @Override
    public List<User> queryUserByType(String type) {
        return userMapper.queryUserByType(type);
    }

    /**
     * 插入用户
     *
     * @param user 用户实体类
     * @param type admin | patrol
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUser(User user, String type) {
        // 获取随机盐值
        user.setSalt(RandomStringUtils.randomAlphanumeric(10));
        // 加密密码
        user.setPassword(new SimpleHash("MD5",
                user.getPassword(),
                user.getSalt(),
                10).toString()
        );
        // 插入用户
        userMapper.insertSelective(user);

        // 配置用户关联角色
        UserToRole userToRole = new UserToRole();
        userToRole.setUserId(user.getId());

        List<Role> roles = roleMapper.selectAll();
        for (Role r : roles) {
            if (type.equals(r.getName())) {
                userToRole.setRoleId(r.getId());
                break;
            }
        }
        return userToRoleMapper.insertSelective(userToRole);
    }


    /**
     * 删除用户
     *
     * @param uId 用户ID
     * @return 返回删除条目数
     * @author 杨新杰
     * @date 2019/7/23 11:20
     **/
    @Override
    public int deleteUser(String uId) {
        User u = new User();
        u.setId(Integer.valueOf(uId));
        u.setIsDel(Boolean.TRUE);
        u.setIsEnable(Boolean.FALSE);
        return userMapper.updateByPrimaryKeySelective(u);
    }


    /**
     * 修改密码
     *
     * @param uId    用户ID
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updatePwdByUserId(String uId, String oldPwd, String newPwd) {
        // 查询用户信息
        Example e = new Example(User.class);
        e.createCriteria().andCondition("id=", uId);
        User user = userMapper.selectOneByExample(e);
        if (user == null) {
            return "用户不存在";
        }
        // 加密密码
        String simStr = new SimpleHash("MD5", oldPwd, user.getSalt(), 10).toString();
        if (!simStr.equals(user.getPassword())) {
            return "旧密码不正确";
        }
        // 设置新密码
        user.setPassword(new SimpleHash("MD5", newPwd, user.getSalt(), 10).toString());
        // 更新密码
        return userMapper.updateByPrimaryKeySelective(user) > 0 ? "修改成功" : "修改失败";
    }
}
