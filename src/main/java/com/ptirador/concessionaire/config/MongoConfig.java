package com.ptirador.concessionaire.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.singletonList;

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

    @Value("${spring.data.mongodb.user}")
    private String dbUser;

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
    @Bean
    public Mongo mongo() throws Exception {
        ServerAddress serverAddress = new ServerAddress(dbHost, dbPort);
        return new MongoClient(serverAddress, getCredentialsList());
    }

    private List<MongoCredential> getCredentialsList() {
        return singletonList(MongoCredential.createCredential(dbUser, getDatabaseName(), dbPassword.toCharArray()));
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        List<String> basePackages = new ArrayList<>();
        basePackages.add(dbBasePackage);
        return basePackages;
    }
}
