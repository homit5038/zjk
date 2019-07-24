package com.it100000.controller.patrol;

import com.it100000.dto.BasicResult;
import com.it100000.entity.Attendance;
import com.it100000.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 检察员上下班
 *
 * @author 杨新杰
 * @date 2019/7/2315:19
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/patrol/attendance")
public class PatrolAttendanceController {

    @Resource
    private AttendanceService attendanceService;

    /**
     * 上下班打卡
     *
     * @param attendance 考勤实体类
     * @return com.it100000.dto.BasicResult 返回打卡结果
     * @author 杨新杰
     * @date 2019/7/23 15:21
     **/
    @RequiresRoles(value = {"patrol", "admin"}, logical = Logical.OR)
    @RequestMapping(value = "/punch", method = RequestMethod.POST)
    public BasicResult punch(Attendance attendance) {
        if (attendanceService.punch(attendance) > 0){
            return BasicResult.successResult();
        } else {
            return BasicResult.failureResult();
        }
    }


}
