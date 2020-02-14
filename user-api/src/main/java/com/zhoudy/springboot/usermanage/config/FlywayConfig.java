package com.zhoudy.springboot.usermanage.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Autowired
    @Qualifier("userDataSource")
    private DataSource userDataSource;

    @Autowired
    @Qualifier("quartzDataSource")
    private DataSource quartzDataSource;

    @PostConstruct
    public void migrateUser(){
        Flyway flyway=Flyway.configure()
                .dataSource(userDataSource)
                .locations("db/migration/user")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
    }

    @PostConstruct
    public void migrateQuartz(){
        Flyway flyway=Flyway.configure()
                .dataSource(quartzDataSource)
                .locations("db/migration/quartz")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
    }
}
