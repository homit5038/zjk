package com.it100000.service;

import com.it100000.entity.SystemParam;

/**
 * @author 杨新杰
 * @date 2019/7/2315:59
 */
public interface SystemParamService {

    /**
     * 设置系统参数
     *
     * @param param 系统参数
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 16:03
     **/
    int settingSystemParam(SystemParam param);

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
    SystemParam querySystemParam(String type);
}
