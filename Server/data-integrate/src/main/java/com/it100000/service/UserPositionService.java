package com.it100000.service;

import com.it100000.entity.UserPosition;

/**
 * @author 杨新杰
 * @date 2019/7/2211:48
 */
public interface UserPositionService {

    /**
     * 用户位置信息插入
     *
     * @param position
     * @return int
     * @author 杨新杰
     * @date 2019/7/22 11:51
     **/
    int insert(UserPosition position);
}
