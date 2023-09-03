package com.sangkhim.spring_boot3_multitenancy;

import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot3MultitenancyApplication {

  public static final Properties defaultProperties = new Properties();

  public static void main(String[] args) {
    defaultProperties.setProperty("lang", "en");

    SpringApplication.run(SpringBoot3MultitenancyApplication.class, args);
  }
}
