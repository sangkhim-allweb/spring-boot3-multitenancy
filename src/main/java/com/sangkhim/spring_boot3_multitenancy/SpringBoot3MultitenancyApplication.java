package com.sangkhim.spring_boot3_multitenancy;

import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;

@SpringBootApplication(exclude = {FlywayAutoConfiguration.class})
public class SpringBoot3MultitenancyApplication {

  public static final Properties defaultProperties = new Properties();

  public static void main(String[] args) {
    defaultProperties.setProperty("lang", "fr");

    SpringApplication.run(SpringBoot3MultitenancyApplication.class, args);
  }
}
