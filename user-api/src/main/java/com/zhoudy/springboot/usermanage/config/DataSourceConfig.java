//package com.zhoudy.springboot.usermanage.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.util.StringUtils;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Primary/**表示其是主数据源*/
//    @Bean(name="userDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.user")
//    public DataSource userDataSource(){
//        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
//        return druidDataSource;    }
//
//    /**
//     * 创建 quartz 数据源
//     */
//    @Bean(name = "quartzDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.quartz")
//    public DataSource quartzDataSource() {
//        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
//        return druidDataSource;
//    }
//
//}
