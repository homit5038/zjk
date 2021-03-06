package com.it100000.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it100000.dto.BasicResult;
import com.it100000.entity.Area;
import com.it100000.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 区域(工作区域)
 *
 * @author 杨新杰
 * @date 2019/7/2214:33
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/area")
public class AdminAreaController {

    @Resource
    private AreaService areaService;

    /**
     * 查询所有区域
     *
     * @param pageNum  第几页
     * @param pageSize 查询多少条
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
//    @RequiresRoles(value = "admin")
    @RequiresUser
    @RequestMapping(value = "/queryAreaAll", method = RequestMethod.POST)
    public BasicResult queryAreaAll(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "15") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Area> legalCaseTypes = areaService.queryAreaAll();
        if (legalCaseTypes.size() <= 0) {
            return BasicResult.successResult();
        }
        PageInfo<Area> pInfo = new PageInfo<>(legalCaseTypes);
        return BasicResult.successResult(pInfo);
    }

    /**
     * 更新区域信息
     *
     * @param area 区域信息
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/updateAreaById", method = RequestMethod.POST)
    public BasicResult updateAreaById(Area area) {
        if (area.getId() == null) {
            return new BasicResult(BasicResult.FAILURE, null, "ID不能为空");
        }
        if (areaService.updateAreaById(area) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

    /**
     * 插入区域信息
     *
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/insertArea", method = RequestMethod.POST)
    public BasicResult insertArea(Area area) {
        if (areaService.insertArea(area) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

    /**
     * 删除区域信息
     *
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/deleteArea", method = RequestMethod.POST)
    public BasicResult deleteArea(Integer aId) {
        if (areaService.deleteArea(aId) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

}
