package com.it100000.service;

import com.it100000.entity.Attendance;

/**
 *
 * 考勤设置
 *
 * @author 杨新杰
 * @date 2019/7/2314:27
 */
public interface AttendanceService {

    /**
     * 上下班打卡
     *
     * @param attendance 考勤实体类
     * @return com.it100000.dto.BasicResult 返回打卡结果
     * @author 杨新杰
     * @date 2019/7/23 15:21
     **/
    int punch(Attendance attendance);
}
