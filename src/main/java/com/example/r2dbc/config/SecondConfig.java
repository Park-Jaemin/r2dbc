package com.example.r2dbc.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.DialectResolver;
import org.springframework.data.r2dbc.dialect.R2dbcDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
@EnableR2dbcRepositories(
        basePackages = "com.example.r2dbc.second",
        entityOperationsRef = "secondEntityTemplate"
)
public class SecondConfig {

    @Value("${spring.r2dbc.second.url}")
    private String url;

    @Value("${spring.r2dbc.second.username}")
    private String username;

    @Value("${spring.r2dbc.second.password}")
    private String password;

    @Bean
    @Qualifier(value = "secondConnectionFactory")
    public ConnectionFactory secondConnectionFactory() {
        return ConnectionFactoryBuilder.withUrl(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public R2dbcEntityOperations secondEntityTemplate(@Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory) {
        R2dbcDialect dialect = DialectResolver.getDialect(connectionFactory);
        DatabaseClient databaseClient = DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .build();

        return new R2dbcEntityTemplate(databaseClient, dialect);
    }
}
