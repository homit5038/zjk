package com.it100000.dao;

import com.it100000.entity.Role;
import com.it100000.entity.User;
import com.it100000.utils.TkMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends TkMapper<User> {
    /**
     * 根据用户名查询用户角色
     *
     * @param s 用户名
     * @return 返回查询到的用户角色
     * @author 杨新杰
     * @date 2019/7/22 10:45
     **/
    List<Role> selectRolesByUserName(String s);

    /**
     * 根据用户类型查询用户,如果type为空则查询全部
     *
     * @param type 用户类型
     * @return 返回查询到的用户数据
     * @author 杨新杰
     * @date 2019/7/23 9:40
     **/
    List<User> queryUserByType(@Param("type") String type);
}