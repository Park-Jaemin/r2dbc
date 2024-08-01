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
        basePackages = "com.example.r2dbc.first",
        entityOperationsRef = "firstEntityTemplate"
)
public class FirstConfig {

    @Value("${spring.r2dbc.first.url}")
    private String url;

    @Value("${spring.r2dbc.first.username}")
    private String username;

    @Value("${spring.r2dbc.first.password}")
    private String password;

    @Bean
    @Qualifier(value = "firstConnectionFactory")
    public ConnectionFactory firstConnectionFactory() {
        return ConnectionFactoryBuilder.withUrl(url)
                .username(username)
                .password(password)
                .build();
    }

    @Bean
    public R2dbcEntityOperations firstEntityTemplate(@Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory) {
        R2dbcDialect dialect = DialectResolver.getDialect(connectionFactory);
        DatabaseClient databaseClient = DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .build();

        return new R2dbcEntityTemplate(databaseClient, dialect);
    }
}
