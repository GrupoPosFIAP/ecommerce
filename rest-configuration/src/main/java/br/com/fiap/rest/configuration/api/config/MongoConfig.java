package br.com.fiap.rest.configuration.api.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongodb.username:admin}")
    private String username;
    @Value("${mongodb.pass:pass}")
    private String pass;
    @Value("${mongodb.database:storeDb}")
    private String database;
    @Value("${mongodb.host:localhost}")
    private String host;
    @Value("${mongodb.port:27017}")
    private String port;

    @Override
    public MongoClient mongoClient() {
        StringBuilder connectionSb = new StringBuilder();
        connectionSb.append("mongodb://")
                .append(username).append(":")
                .append(pass).append("@")
                .append(host).append(":")
                .append(port);
        ConnectionString connectionString = new ConnectionString(connectionSb.toString());
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("br.com.fiap.cadastro");
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
