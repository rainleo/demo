package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by niewenlong-work on 2017/7/19.
 */
@Configuration
@ConditionalOnClass({DruidDataSource.class})
@EnableConfigurationProperties({DruidStatProperties.class, DruidDataSourceProperties.class})
@Import({DruidSpringAopConfiguration.class, DruidStatViewServletConfiguration.class, DruidWebStatFilterConfiguration.class})
public class DruidDataSourceAutoConfigure {
    public DruidDataSourceAutoConfigure() {

    }

    @Bean("one")
    @Primary
    public DataSource dataSourceOne(Environment env){
        return DruidDataSourceBuilder
                .create()
                .build(env, "spring.datasource.druid.one.");
    }
    @Bean("two")
    public DataSource dataSourceTwo(Environment env){
        return DruidDataSourceBuilder
                .create()
                .build(env, "spring.datasource.druid.two.");
    }
}
