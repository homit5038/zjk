package com.it100000.utils;

import tk.mybatis.mapper.entity.Example;

/**
 * @author 杨新杰
 * @date 2019/7/2215:01
 */
public class TkUtils {

    /**
     * 添加默认查询条件
     * <p> is_del=false</p>
     * <p> is_enable=true</p>
     *
     * @param e Example
     * @return tk.mybatis.mapper.entity.Example.Criteria
     * @author 杨新杰
     * @date 2019/7/22 16:07
     **/
    public static Example.Criteria AddDefaultQuery(Example e) {
        Example.Criteria criteria = e.createCriteria();
        criteria.andCondition("is_del=", Boolean.FALSE);
        criteria.andCondition("is_enable=", Boolean.TRUE);
        return criteria;
    }
}
