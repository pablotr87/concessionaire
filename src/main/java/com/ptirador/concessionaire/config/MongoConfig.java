package com.ptirador.concessionaire.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = {
        "com.ptirador.concessionaire.repository"
},
        repositoryImplementationPostfix = "CustomImpl")
public class MongoConfig extends AbstractMongoConfiguration {

    /**
     * Default port number.
     */
    private static final int PORT_NUMBER = 27017;

    @Override
    protected String getDatabaseName() {
        return "concessionaire";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(System.getProperty("app.db.ip"), PORT_NUMBER);
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        List<String> basePackages = new ArrayList<>();
        basePackages.add("com.ptirador.concessionaire.model");
        return basePackages;
    }
}
