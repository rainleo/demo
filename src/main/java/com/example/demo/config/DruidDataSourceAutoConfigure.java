package com.example.demo.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.*;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

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

    @Bean("primaryDataSource")
    @Primary
    public DataSource primaryDataSource(Environment env) {
        DruidDataSource dataSource = DruidDataSourceBuilder
                .create()
                .build(env, "spring.datasource.druid.primary.");
        return dataSource;
    }
    @Bean("secondDataSource")
    public DataSource secondDataSource(Environment env){
        DruidDataSource dataSource = DruidDataSourceBuilder
                .create()
                .build(env, "spring.datasource.druid.second.");
        return dataSource;
    }
}
