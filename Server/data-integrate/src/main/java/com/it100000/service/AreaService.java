package com.it100000.service;


import com.it100000.entity.Area;

import java.util.List;

/**
 * @author 杨新杰
 * @date 2019/7/2217:05
 */
public interface AreaService {

    /**
     * 查询所有区域信息
     *
     * @return 返回所有区域信息
     * @author 杨新杰
     * @date 2019/7/22 17:07
     **/
    List<Area> queryAreaAll();

    /**
     * 更新区域信息
     *
     * @param area 区域信息
     * @return 返回更新结果
     * @author 杨新杰
     * @date 2019/7/22 17:14
     **/
    int updateAreaById(Area area);

    /**
     * 新增区域信息
     *
     * @param area 区域信息
     * @return 返回更新结果
     * @author 杨新杰
     * @date 2019/7/22 17:14
     **/
    int insertArea(Area area);

    /**
     * 删除区域信息
     *
     * @param  aId 删除区域信息
     * @return 返回更新结果
     * @author 杨新杰
     * @date 2019/7/22 17:14
     **/
    int deleteArea(Integer aId);
}
