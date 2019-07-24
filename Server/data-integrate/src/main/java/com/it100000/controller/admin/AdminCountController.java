package com.it100000.controller.admin;

import com.it100000.service.CountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * 统计 用于前端数据展示使用接口
 *
 * @author 杨新杰
 * @date 2019/7/2315:40
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/count")
public class AdminCountController {

    @Resource
    private CountService countService;



}
