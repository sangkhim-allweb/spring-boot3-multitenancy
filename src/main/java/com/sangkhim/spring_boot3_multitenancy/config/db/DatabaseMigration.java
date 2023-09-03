package com.sangkhim.spring_boot3_multitenancy.config.db;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseMigration implements ApplicationListener<ContextRefreshedEvent> {

  private final DbConfigProperty dbConfigProperty;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    dbConfigProperty
        .getConfigurations()
        .forEach(
            (key, value) -> {
              Flyway flyway = Flyway.configure().dataSource(value.createDataSource()).load();
              flyway.migrate();
            });
  }
}
