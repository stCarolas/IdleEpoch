package com.github.stcarolas.idleepoch.domain.product.storage;

import javax.inject.Inject;
import javax.inject.Named;
import com.github.stcarolas.idleepoch.domain.product.ProductFactory;
import org.springframework.jdbc.core.JdbcTemplate;

@Named("StorageFactory")
public class StorageFactory {
  private JdbcTemplate jdbc;
  private ProductFactory productFactory;

  @Inject
  public StorageFactory(JdbcTemplate jdbc, ProductFactory productFactory) {
    this.jdbc = jdbc;
    this.productFactory = productFactory;
  }

  public Storage of(String ownerId) {
    return ImmutableStorageImpl.builder()
      .productFactory(productFactory)
      .jdbc(jdbc)
      .build();
  }
}
