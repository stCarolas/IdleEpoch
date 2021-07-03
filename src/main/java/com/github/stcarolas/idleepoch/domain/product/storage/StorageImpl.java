package com.github.stcarolas.idleepoch.domain.product.storage;

import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.product.ProductFactory;
import com.github.stcarolas.idleepoch.domain.product.ImmutablePackage;
import com.github.stcarolas.idleepoch.domain.product.Package;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.immutables.value.Value.Immutable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;
import static io.vavr.API.*;

@Immutable
public abstract class StorageImpl implements Storage {
  private static final Logger log = LogManager.getLogger();

  abstract JdbcTemplate jdbc();
  abstract ProductFactory productFactory();

  private RowMapper<Package<Product>> packageMapper = (rs, rowNum) -> {
    Product product = productFactory()
      .byName(rs.getString("name"))
      .getOrElseThrow(() -> new RuntimeException("wrong product name"));
    return ImmutablePackage.<Product>builder()
      .product(product)
      .amount(rs.getLong("amount"))
      .build();
  };

  @Override
  public Try<?> addPackage(Package<? extends Product> pack) {
    return Try(
      () -> jdbc()
        .update(
          "insert into storage_products (villager_id, name, amount) values (?, ?, ?)",
          ownerId(),
          pack.product().name(),
          pack.amount()
        )
    )
      .onFailure(log::error);
  }

  @Override
  public Try<List<Package<Product>>> products() {
    return Try(
      () -> jdbc()
        .query(
          "select name,amount from storage_products where villager_id = ?",
          packageMapper,
          ownerId()
        )
    )
      .map(List::ofAll)
      .onFailure(log::error);
  }

  @Override
  public Try<Option<Package<Product>>> findPackageOf(Product product) {
    return Try(
      () -> jdbc()
        .queryForObject(
          "select name,amount from storage_products where villager_id = ? and name = ?",
          packageMapper,
          ownerId(),
          product.name()
        )
    )
      .map(Option::of)
      .onFailure(log::error);
  }
}
