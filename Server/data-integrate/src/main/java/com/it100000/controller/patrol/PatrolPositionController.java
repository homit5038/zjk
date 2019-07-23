package com.it100000.controller.patrol;

import com.it100000.dto.BasicResult;
import com.it100000.entity.UserPosition;
import com.it100000.service.UserPositionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 巡查员位置信息上传
 *
 * @author 杨新杰
 * @date 2019/7/2211:44
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/patrol")
public class PatrolPositionController {

    @Resource
    private UserPositionService positionService;

    /**
     * 上传位置信息
     *
     * @param position 用户经纬度信息
     * @return 返回上传结果
     */
    @RequiresRoles(value = {"patrol", "admin"}, logical = Logical.OR)
    @RequestMapping("/uploadPosition")
    public BasicResult uploadPosition(UserPosition position) {
        position.setUploadTime(new Date());
        if (positionService.insert(position) > 0) {
            return BasicResult.successResult(position);
        } else {
            return BasicResult.failureResult(position);
        }
    }

    // 判断当前用户位置是否在工作区域内


}
