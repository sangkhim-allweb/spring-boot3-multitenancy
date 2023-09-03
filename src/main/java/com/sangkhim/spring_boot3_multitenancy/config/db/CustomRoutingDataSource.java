package com.sangkhim.spring_boot3_multitenancy.config.db;

import com.sangkhim.spring_boot3_multitenancy.SpringBoot3MultitenancyApplication;
import java.util.Objects;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    String lang = SpringBoot3MultitenancyApplication.defaultProperties.getProperty("lang");
    System.out.println("lang = " + lang);
    if (Objects.nonNull(lang)) {
      return lang;
    } else {
      return "en";
    }
  }
}
