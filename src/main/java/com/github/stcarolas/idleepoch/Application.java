package com.github.stcarolas.idleepoch;

import javax.inject.Inject;
import com.github.stcarolas.idleepoch.domain.product.ImmutablePackage;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import com.github.stcarolas.idleepoch.domain.product.storage.ImmutableStorageImpl;
import com.github.stcarolas.idleepoch.domain.product.storage.StorageImplFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
  @Inject
  JdbcTemplate jdbc;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    ImmutableStorageImpl.builder()
      .jdbc(jdbc)
      .ownerId("owner")
      .build()
      .addPackage(
        ImmutablePackage.<Copper>builder().product(new Copper()).amount(2L).build()
      );
  }
}
