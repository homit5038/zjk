package com.it100000.controller.admin;

import com.it100000.dto.BasicResult;
import com.it100000.entity.SystemParam;
import com.it100000.service.SystemParamService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * 系统参数设置
 *
 * @author 杨新杰
 * @date 2019/7/2315:59
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/system_param")
public class AdminSystemParamController {

    @Resource
    private SystemParamService systemParamService;

    /**
     * 设置系统参数
     *
     * @param param 系统参数
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 16:03
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/settingSystemParam", method = RequestMethod.POST)
    public BasicResult settingSystemParam(SystemParam param) {
        if (systemParamService.settingSystemParam(param) > 0) {
            return BasicResult.successResult();
        } else {
            return BasicResult.failureResult();
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
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/querySystemParam", method = RequestMethod.POST)
    public BasicResult querySystemParam(@NotBlank(message = "参数类型不能为空") String type) {
        SystemParam param = systemParamService.querySystemParam(type);
        if (param == null) {
            return BasicResult.failureResult();
        } else {
            return BasicResult.successResult(param);
        }
    }


}
