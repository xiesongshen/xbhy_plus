package com.xss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
@Configuration
@ComponentScan("com.xss.service")
@EnableTransactionManagement
@PropertySource(value="classpath:sysPicPath.properties",encoding = "utf-8")
public class SpringTransactionConfig {

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
