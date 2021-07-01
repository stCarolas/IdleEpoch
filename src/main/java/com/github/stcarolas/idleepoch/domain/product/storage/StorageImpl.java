package com.github.stcarolas.idleepoch.domain.product.storage;

import javax.inject.Inject;
import com.github.stcarolas.enrichedbeans.annotations.Assisted;
import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.product.Package;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.immutables.value.Value.Immutable;
import org.springframework.jdbc.core.JdbcTemplate;
import io.vavr.control.Try;
import static io.vavr.API.*;

@Immutable
@Assisted(useBuilder = true)
public abstract class StorageImpl extends Storage {
  private static final Logger log = LogManager.getLogger();

  @Inject
  abstract JdbcTemplate jdbc();

  @Override
  public Try<?> addPackage(Package<? extends Product> pack) {
    return Try(
      () -> jdbc()
        .update(
          "insert into storage_products (wayfarer_id, name, amount) values (?, ?, ?)",
          ownerId(),
          pack.product().name(),
          pack.amount()
        )
    ).onFailure(log::error);
  }
}
