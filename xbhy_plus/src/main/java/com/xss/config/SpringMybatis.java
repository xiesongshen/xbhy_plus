package com.xss.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
@Configuration
@MapperScan("com.xss.mapper")
@Import(SpringTransactionConfig.class)
public class SpringMybatis {

    @Bean
    public DruidDataSource geDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        InputStream is = SpringMybatis.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
            dataSource.configFromPropety(pro);
            return dataSource;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        tk.mybatis.mapper.session.Configuration configuration =
                new tk.mybatis.mapper.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCallSettersOnNulls(true);
        sqlSessionFactoryBean.setConfiguration(configuration);

        //设置分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();//分页拦截对象
        pageInterceptor.setProperties(new Properties());//设置参数，用于生成默认的方言
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }
}
