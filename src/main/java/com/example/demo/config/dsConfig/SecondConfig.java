package com.example.demo.config.dsConfig;

import com.example.demo.config.DruidDataSourceAutoConfigure;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Created by niewenlong-work on 2017/7/19.
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.dao.second", sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondConfig {
    @Autowired
    DruidDataSourceAutoConfigure druidDataSourceAutoConfigure;

    @Bean  // 如果这里不用 Qualifier 指定, 则注入的是Primary数据源
    public SqlSessionFactory secondSqlSessionFactory(Environment environment) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(druidDataSourceAutoConfigure.dataSourceTwo(environment));
        // 领域模型包位置
        sessionFactory.setTypeAliasesPackage("com.example.demo.dao.second");
        // 设置映射文件的位置
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/second/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate ds0SqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}