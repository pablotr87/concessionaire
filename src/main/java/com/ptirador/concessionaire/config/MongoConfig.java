package com.ptirador.concessionaire.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.*;

@Configuration
@EnableMongoRepositories(basePackages = {
        "com.ptirador.concessionaire.repository"
},
        repositoryImplementationPostfix = "CustomImpl")
@PropertySource("classpath:application.properties")
public class MongoConfig extends AbstractMongoConfiguration {

    /**
     * Database host.
     */
    @Value("${spring.data.mongodb.host}")
    private String dbHost;

    /**
     * Default port number.
     */
    @Value("${spring.data.mongodb.port}")
    private Integer dbPort;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${spring.data.mongodb.basePackage}")
    private String dbBasePackage;

    @Value("${spring.data.mongodb.username}")
    private String dbUserName;

    @Value("${spring.data.mongodb.password}")
    private String dbPassword;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public MongoClient mongo() throws Exception {
        ServerAddress serverAddress = new ServerAddress(dbHost, dbPort);
        return new MongoClient(serverAddress, getCredentialsList());
    }

    private List<MongoCredential> getCredentialsList() {
        return Collections.singletonList(MongoCredential.createCredential(dbUserName, getDatabaseName(),
                dbPassword.toCharArray()));
    }

    @Override
    @Bean
    public SimpleMongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongo(), getDatabaseName());
    }

    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }


    @Override
    protected Collection<String> getMappingBasePackages() {
        List<String> basePackages = new ArrayList<>();
        basePackages.add(dbBasePackage);
        return basePackages;
    }
}
