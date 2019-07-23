package com.it100000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot启动类
 * <p>@EnableScheduling 开启定时任务</p>
 * <p>@EnableTransactionManagement  开启事务</p>
 * @author 杨新杰
 */
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.it100000.dao")
@SpringBootApplication
public class DataIntegrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataIntegrateApplication.class, args);
    }

}
