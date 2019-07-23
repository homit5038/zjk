package com.it100000.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * 整合TkMapper使用
 * <p>注:不能被扫描到.否则会出错</p>
 *
 * @author 杨新杰
 * @date 2019/7/1021:37
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
