package com.it100000.service.impl;

import com.it100000.dao.UserMapper;
import com.it100000.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserServiceImplTest {


    @Resource
    UserMapper userMapper;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void test01() throws Exception {
        User u = new User();
        u.setUsername("1111");
        u.setPassword("1111");
        u.setSalt("1111");
        userMapper.insertSelective(u);


        User u2 = new User();
        u.setUsername("2222");
        u.setPassword("2222");
        u.setSalt("2222");
        userMapper.insertSelective(u2);

        throw new Exception();
    }


    @Test
    public void test02(){
        BigDecimal lng = new BigDecimal("0.111111113");
        System.out.println(lng.toString());
    }



}