package com.it100000.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it100000.dto.BasicResult;
import com.it100000.entity.LegalCase;
import com.it100000.entity.LegalCaseType;
import com.it100000.service.LegalCaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 案件and案件分类
 *
 * @author 杨新杰
 * @date 2019/7/2214:33
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/legal_case")
public class AdminLegalCaseTypeController {

    @Resource
    private LegalCaseService legalCaseService;


    /////////////////////// 案件分类

    /**
     * 查询所有案件分类
     *
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/queryLegalCaseTypeAll", method = RequestMethod.POST)
    public BasicResult queryLegalCaseTypeAll(@RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "15") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LegalCaseType> legalCaseTypes = legalCaseService.selectLegalCaseTypeAll();
        if (legalCaseTypes.size() <= 0) {
            return BasicResult.successResult();
        }
        return BasicResult.successResult(new PageInfo<>(legalCaseTypes));
    }

    /**
     * 更新案件分类信息
     *
     * @param legalCaseType 案件分类
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/updateLegalCaseType", method = RequestMethod.POST)
    public BasicResult updateLegalCaseType(LegalCaseType legalCaseType) {
        if (legalCaseType.getId() == null) {
            return new BasicResult(BasicResult.FAILURE, null, "ID不能为空");
        }
        if (legalCaseService.updateLegalCaseTypeById(legalCaseType) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

    /**
     * 插入案件分类
     *
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/insertLegalCaseType", method = RequestMethod.POST)
    public BasicResult insertLegalCaseType(LegalCaseType legalCaseType) {
        if (legalCaseService.insertLegalCaseType(legalCaseType) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

    /**
     * 删除案件分类
     *
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/deleteLegalCaseType", method = RequestMethod.POST)
    public BasicResult deleteLegalCaseType(Integer lId) {
        if (legalCaseService.deleteLegalCaseType(lId) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

    /////////////////////// 案件

    /**
     * 查询所有案件
     *
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/queryLegalCaseAll", method = RequestMethod.POST)
    public BasicResult queryLegalCaseAll(@RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "15") Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<LegalCase> legalCases = legalCaseService.selectLegalCaseAll();
        if (legalCases.size() <= 0) {
            return BasicResult.successResult();
        }
        PageInfo<LegalCase> pInfo = new PageInfo<>(legalCases);
        return BasicResult.successResult(pInfo);
    }

    /**
     * 更新案件信息
     *
     * @param legalCase 案件
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/updateLegalCase", method = RequestMethod.POST)
    public BasicResult updateLegalCase(LegalCase legalCase) {
        if (legalCase.getId() == null) {
            return new BasicResult(BasicResult.FAILURE, null, "ID不能为空");
        }
        if (legalCaseService.updateLegalCaseById(legalCase) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

    /**
     * 插入案件
     *
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/insertLegalCase", method = RequestMethod.POST)
    public BasicResult insertLegalCase(LegalCase legalCase) {
        if (legalCaseService.insertLegalCase(legalCase) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

    /**
     * 删除案件
     *
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/22 14:41
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/deleteLegalCase", method = RequestMethod.POST)
    public BasicResult deleteLegalCase(Integer lId) {
        if (legalCaseService.deleteLegalCase(lId) <= 0) {
            return BasicResult.failureResult();
        }
        return BasicResult.successResult();
    }

}
