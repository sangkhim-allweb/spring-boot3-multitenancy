package com.sangkhim.spring_boot3_multitenancy;

import com.sangkhim.spring_boot3_multitenancy.config.DbConfig;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(DbConfig.class)
@RequiredArgsConstructor
public class SpringBoot3MultitenancyApplication {

  private final DbConfig dbConfig;

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot3MultitenancyApplication.class, args);
  }

  @Bean
  public DataSource dataSource() {
    CustomRoutingDataSource dataSource = new CustomRoutingDataSource();
    dataSource.setTargetDataSources(dbConfig.createTargetDataSources());
    return dataSource;
  }
}
