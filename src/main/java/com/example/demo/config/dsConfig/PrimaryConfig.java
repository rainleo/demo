package com.example.demo.config.dsConfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo.config.DruidDataSourceAutoConfigure;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by niewenlong-work on 2017/7/19.
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.dao.primary", sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryConfig {
    @Autowired
    DruidDataSourceAutoConfigure druidDataSourceAutoConfigure;

    @Bean  // 如果这里不用 Qualifier 指定, 则注入的是Primary数据源
    public SqlSessionFactory primarySqlSessionFactory(Environment environment) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(druidDataSourceAutoConfigure.dataSourceOne(environment));
        // 领域模型包位置
        sessionFactory.setTypeAliasesPackage("com.example.demo.dao.primary");
        // 设置映射文件的位置
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/primary/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate ds0SqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
