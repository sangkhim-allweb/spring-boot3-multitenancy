package com.sangkhim.spring_boot3_multitenancy.config.db;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseMigration implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired private DbConfigProperty dbConfigProp;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    dbConfigProp
        .getConfigurations()
        .forEach(
            (key, value) -> {
              Flyway flyway = Flyway.configure().dataSource(value.createDataSource()).load();
              flyway.migrate();
            });
  }
}
