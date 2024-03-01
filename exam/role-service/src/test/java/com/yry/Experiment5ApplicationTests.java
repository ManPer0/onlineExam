package com.yry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Experiment5ApplicationTests {

    @Autowired
    @Lazy
    DataSource dataSource;

    @Test
    void contextLoads() throws Exception {
        System.out.println("获取的数据库连接为:" + dataSource.getConnection());
    }
}
