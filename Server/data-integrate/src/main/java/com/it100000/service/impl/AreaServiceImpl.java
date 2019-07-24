package com.it100000.service.impl;

import com.github.pagehelper.PageInfo;
import com.it100000.dao.AreaMapper;
import com.it100000.entity.Area;
import com.it100000.service.AreaService;
import com.it100000.utils.TkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 杨新杰
 * @date 2019/7/2217:06
 */
@Slf4j
@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaMapper areaMapper;

    /**
     * 查询所有区域信息
     *
     * @return 返回所有区域信息
     * @author 杨新杰
     * @date 2019/7/22 17:07
     **/
    @Override
    public List<Area> queryAreaAll() {

        Example e = new Example(Area.class);
        TkUtils.AddDefaultQuery(e);
        List<Area> lA =  areaMapper.selectByExample(e);

        return lA;
    }

    /**
     * 更新区域信息
     *
     * @param area 区域信息
     * @return 返回更新结果
     * @author 杨新杰
     * @date 2019/7/22 17:14
     **/
    @Override
    public int updateAreaById(Area area) {
        area.setUpdateTime(new Date());
        return areaMapper.updateByPrimaryKeySelective(area);
    }

    /**
     * 新增区域信息
     *
     * @param area 区域信息
     * @return 返回更新结果
     * @author 杨新杰
     * @date 2019/7/22 17:14
     **/
    @Override
    public int insertArea(Area area) {
        area.setCreateTime(new Date());
        return areaMapper.insertSelective(area);
    }

    /**
     * 删除区域信息
     *
     * @param aId 删除区域信息
     * @return 返回更新结果
     * @author 杨新杰
     * @date 2019/7/22 17:14
     **/
    @Override
    public int deleteArea(Integer aId) {
        Area area = new Area();
        area.setId(aId);
        area.setIsDel(Boolean.TRUE);
        area.setIsEnable(Boolean.FALSE);
        return areaMapper.updateByPrimaryKeySelective(area);
    }
}
