package com.it100000.service.impl;

import com.it100000.dao.AttendanceMapper;
import com.it100000.entity.Attendance;
import com.it100000.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 杨新杰
 * @date 2019/7/2314:27
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Resource
    private AttendanceMapper attendanceMapper;

    /**
     * 上下班打卡
     *
     * @param attendance 考勤实体类
     * @return com.it100000.dto.BasicResult 返回打卡结果
     * @author 杨新杰
     * @date 2019/7/23 15:21
     **/
    @Override
    public int punch(Attendance attendance) {
        attendance.setPunchTime(new Date());
        return attendanceMapper.insertSelective(attendance);
    }
}
