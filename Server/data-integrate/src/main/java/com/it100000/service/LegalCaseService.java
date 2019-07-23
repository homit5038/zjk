package com.it100000.service;

import com.it100000.entity.LegalCase;
import com.it100000.entity.LegalCaseType;

import java.util.List;

/**
 * @author 杨新杰
 * @date 2019/7/2214:42
 */
public interface LegalCaseService {

    /**
     * 查询所有案件分类
     *
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    List<LegalCaseType> selectLegalCaseTypeAll();

    /**
     * 更新案件分类
     *
     * @param legalCaseType 案件分类实体类
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    int updateLegalCaseTypeById(LegalCaseType legalCaseType);

    /**
     * 新增案件分类
     *
     * @param legalCaseType 案件分类实体类
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    int insertLegalCaseType(LegalCaseType legalCaseType);

    /**
     * 删除案件分类(逻辑山粗)
     *
     * @param lId 案件分类实体类
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    int deleteLegalCaseType(Integer lId);

    /**
     * 查询所有案件
     *
     * @return java.util.List<com.it100000.entity.LegalCaseType>
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    List<LegalCase> selectLegalCaseAll();

    /**
     * 查询所有案件
     *
     * @param legalCase 案件
     * @return int
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    int updateLegalCaseById(LegalCase legalCase);

    /**
     * 插入所有案件
     *
     * @param legalCase 案件
     * @return int
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    int insertLegalCase(LegalCase legalCase);

    /**
     * 插入所有案件
     *
     * @param lId 案件ID
     * @return int
     * @author 杨新杰
     * @date 2019/7/22 14:45
     **/
    int deleteLegalCase(Integer lId);
}
