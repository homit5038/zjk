package com.it100000.service.impl;

import com.it100000.dao.UserPositionMapper;
import com.it100000.entity.UserPosition;
import com.it100000.service.UserPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 杨新杰
 * @date 2019/7/2211:48
 */
@Slf4j
@Service
public class UserPositionServiceImpl implements UserPositionService {

    @Resource
    private UserPositionMapper positionMapper;

    /**
     * 用户位置信息插入
     *
     * @param position
     * @return int
     * @author 杨新杰
     * @date 2019/7/22 11:51
     **/
    @Override
    public int insert(UserPosition position) {
        return positionMapper.insert(position);
    }
}
