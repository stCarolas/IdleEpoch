package com.github.stcarolas.idleepoch.domain.storage;

import org.junit.jupiter.api.Test;

import com.github.stcarolas.idleepoch.TestWithDatabase;
import com.github.stcarolas.idleepoch.domain.product.ImmutablePack;
import com.github.stcarolas.idleepoch.domain.product.ProductFactory;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import org.apache.commons.lang3.RandomStringUtils;
import static org.junit.jupiter.api.Assertions.*;
import static io.vavr.API.*;

public class StorageImplTest extends TestWithDatabase {
  ProductFactory productFactory = new ProductFactory();

  @Test
  public void insertingProduct() {
    String ownerId = RandomStringUtils.random(10);
    Copper product = Copper.of();
    Long productAmount = 2L;

    Storage storage = ImmutableStorageImpl.builder()
      .jdbc(jdbc())
      .ownerId(ownerId)
      .productFactory(productFactory)
      .build();
    storage.addPack(ImmutablePack.of(productAmount, product));
    assertEquals(
      Success(List(ImmutablePack.of(productAmount, product))),
      storage.products()
    );
  }

  @Test
  public void findProduct() {
    String ownerId = RandomStringUtils.random(10);
    Copper product = Copper.of();
    Long productAmount = 2L;

    Storage storage = ImmutableStorageImpl.builder()
      .jdbc(jdbc())
      .ownerId(ownerId)
      .productFactory(productFactory)
      .build();
    storage.addPack(ImmutablePack.of(productAmount, product));
    assertEquals(
      Success(Some(ImmutablePack.of(productAmount, product))),
      storage.findPackOf(product)
    );
  }

}
