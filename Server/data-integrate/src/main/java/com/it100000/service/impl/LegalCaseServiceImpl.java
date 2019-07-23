package com.it100000.service.impl;

import com.it100000.dao.LegalCaseMapper;
import com.it100000.dao.LegalCaseTypeMapper;
import com.it100000.entity.LegalCase;
import com.it100000.entity.LegalCaseType;
import com.it100000.service.LegalCaseService;
import com.it100000.utils.TkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 杨新杰
 * @date 2019/7/2214:42
 */
@Slf4j
@Service
public class LegalCaseServiceImpl implements LegalCaseService {

    @Resource
    private LegalCaseTypeMapper legalCaseTypeMapper;

    @Resource
    private LegalCaseMapper legalCaseMapper;

    /**
     * 查询所有案件分类
     *
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    @Override
    public List<LegalCaseType> selectLegalCaseTypeAll() {
        Example e = new Example(LegalCaseType.class);
        TkUtils.AddDefaultQuery(e);
        return legalCaseTypeMapper.selectByExample(e);
    }

    /**
     * 更新案件分类
     *
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    @Override
    public int updateLegalCaseTypeById(LegalCaseType legalCaseType) {
        return legalCaseTypeMapper.updateByPrimaryKeySelective(legalCaseType);
    }

    /**
     * 新增案件分类
     *
     * @param legalCaseType 案件分类实体类
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    @Override
    public int insertLegalCaseType(LegalCaseType legalCaseType) {
        return legalCaseTypeMapper.insertSelective(legalCaseType);
    }

    /**
     * 删除案件分类(逻辑山粗)
     *
     * @param lId 案件分类实体类
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    @Override
    public int deleteLegalCaseType(Integer lId) {
        LegalCaseType type = new LegalCaseType();
        type.setId(lId);
        type.setIsDel(Boolean.TRUE);
        type.setIsEnable(Boolean.FALSE);
        return legalCaseTypeMapper.updateByPrimaryKeySelective(type);
    }

    /**
     * 查询所有案件
     *
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    @Override
    public List<LegalCase> selectLegalCaseAll() {
        Example e = new Example(LegalCase.class);
        TkUtils.AddDefaultQuery(e);
        return legalCaseMapper.selectByExample(e);
    }

    /**
     * 查询所有案件
     *
     * @param legalCase 案件
     * @return int
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    @Override
    public int updateLegalCaseById(LegalCase legalCase) {
        return legalCaseMapper.updateByPrimaryKeySelective(legalCase);
    }

    /**
     * 插入所有案件
     *
     * @param legalCase 案件
     * @return int
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    @Override
    public int insertLegalCase(LegalCase legalCase) {
        legalCase.setCreateTime(new Date());
        return legalCaseMapper.insertSelective(legalCase);
    }

    /**
     * 插入所有案件
     *
     * @param lId 案件ID
     * @return int
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    @Override
    public int deleteLegalCase(Integer lId) {
        LegalCase legalCase = new LegalCase();
        legalCase.setId(lId);
        legalCase.setIsDel(Boolean.TRUE);
        legalCase.setIsEnable(Boolean.FALSE);
        return legalCaseMapper.updateByPrimaryKeySelective(legalCase);
    }
}
