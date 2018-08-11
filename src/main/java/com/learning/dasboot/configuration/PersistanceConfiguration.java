package com.learning.dasboot.configuration;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PersistanceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @FlywayDataSource
    @ConfigurationProperties(prefix = "datasource.flyway")
    public DataSourceProperties flywayDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @FlywayDataSource
    @ConfigurationProperties(prefix = "datasource.flyway")
    public DataSource flywayDataSource() {
        return flywayDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
