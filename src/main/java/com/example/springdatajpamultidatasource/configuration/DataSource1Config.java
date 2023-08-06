package com.example.springdatajpamultidatasource.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import jakarta.persistence.EntityManagerFactory;


import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory1", basePackages = {
        "com.example.springdatajpamultidatasource.repository.source1" })
public class DataSource1Config {
    @Primary
    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource-source1")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("dataSource1") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("").persistenceUnit("Customer").build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory1") EntityManagerFactory entityManagerFactory1) {
        return new JpaTransactionManager(entityManagerFactory1);
    }
}