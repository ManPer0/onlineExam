package com.yry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class TransactionManagement {
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager();
    }
}
