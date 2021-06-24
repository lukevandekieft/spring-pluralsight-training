package com.pluralsight.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
  @Bean
  public DataSource dataSource() {
    DataSourceBuilder builder = DataSourceBuilder.create();
    builder.url("jdbc:postgresql://localhost:5432/conference_app");
    // This shows that this config is used during Spring startup
    System.out.println("My Datasource Bean is legit!");
    return builder.build();
  }
}
