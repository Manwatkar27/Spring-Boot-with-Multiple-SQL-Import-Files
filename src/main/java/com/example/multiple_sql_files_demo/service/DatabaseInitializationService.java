package com.example.multiple_sql_files_demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Arrays;

@Service
public class DatabaseInitializationService {

    private final DataSource dataSource;

    @Value("classpath:db/migration/schema/*.sql")
    private Resource[] schemaScripts;

    @Value("classpath:db/migration/data/*.sql")
    private Resource[] dataScripts;

    public DatabaseInitializationService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void initializeDatabase() {
        executeScripts(schemaScripts);
        executeScripts(dataScripts);
    }

    private void executeScripts(Resource[] scripts) {
        Arrays.stream(scripts).forEach(script -> {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator(script);
            populator.execute(dataSource);
        });
    }
}

