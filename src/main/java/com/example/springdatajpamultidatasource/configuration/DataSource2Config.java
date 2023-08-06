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
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory2", basePackages = {
        "com.example.springdatajpamultidatasource.repository.source2" })
public class DataSource2Config {
    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource-source2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(EntityManagerFactoryBuilder builder,
                                                                        @Qualifier("dataSource2") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("").persistenceUnit("Product").build();
    }

    @Bean
    public PlatformTransactionManager transactionManager2(
            @Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory2) {
        return new JpaTransactionManager(entityManagerFactory2);
    }
}