package com.masood.springbootcarnet.modules.m_14;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    @Value("${custom.datasource.url}")
    private String dataSourceUrl;

   @Value("${custom.datasource.username}")
    private String username = "C##MASOOD";

    @Value("${custom.datasource.password}")
    private String password;

    @Value("${custom.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {

        HikariDataSource dataSource = new HikariDataSource();


        dataSource.setJdbcUrl(dataSourceUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setConnectionTimeout(1000);

        System.out.println("Database Object Created Successfully");
        return dataSource;

    }
}
