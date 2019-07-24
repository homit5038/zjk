package com.it100000.service.impl;

import com.it100000.dao.SystemParamMapper;
import com.it100000.entity.SystemParam;
import com.it100000.service.SystemParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author 杨新杰
 * @date 2019/7/2315:59
 */
@Slf4j
@Service
public class SystemParamServiceImpl implements SystemParamService {

    @Resource
    private SystemParamMapper systemParamMapper;


    /**
     * 设置系统参数
     *
     * @param param 系统参数
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 16:03
     **/
    @Override
    public int settingSystemParam(SystemParam param) {
        // 先查询是否存在
        Example e = new Example(SystemParam.class);
        e.createCriteria().andCondition("type="+ param.getType());
        SystemParam systemParam = systemParamMapper.selectOneByExample(e);
        if (systemParam == null){
            // 不存在则插入
            return systemParamMapper.insertSelective(param);
        } else  {
            // 存在则更新
            param.setId(systemParam.getId());
            return systemParamMapper.updateByPrimaryKeySelective(param);
        }
    }

    /**
     * 获取参数
     *
     * @param type 参数类型
     *             0-人员聚集警告设置(人数)
     *             1-停留时间过长警报设置(时间 min)
     *             2-无回传警报设置(时间  min)
     *             3-离开工作区域警报(时间 min)
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/24 9:21
     **/
    @Override
    public SystemParam querySystemParam(String type) {
        Example e = new Example(SystemParam.class);
        e.createCriteria().andCondition("type=",type);
        return systemParamMapper.selectOneByExample(e);
    }
}
