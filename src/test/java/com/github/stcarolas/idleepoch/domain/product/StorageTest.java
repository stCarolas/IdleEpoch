package com.github.stcarolas.idleepoch.domain.product;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.vavr.control.Option;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stcarolas.idleepoch.domain.wayfarer.Wayfarer;

import org.apache.commons.lang3.RandomUtils;
import static io.vavr.API.*;

public class StorageTest {

  Wayfarer wayfarer = Mockito.mock(Wayfarer.class);
  Product product = new Product() {

    @Override
    public String name() {
      return "TestProduct";
    }
  };

  @Test
  public void testEmptyStorage() {
    assertTrue(new Storage(wayfarer).products().keySet().isEmpty());
  }

  @Test
  public void testAddProduct() {
    Storage storage = new Storage(wayfarer);
    assertTrue(storage.addProduct(product, 2L).isSuccess());
    Option<Long> storedProductCount = storage.products().get(product.name());
    assertTrue(storedProductCount.isDefined());
    assertTrue(storedProductCount.exists(count -> count == 2L));
  }

  @Test
  public void testAddPackage() {
    Storage storage = new Storage(wayfarer);
    long amount = RandomUtils.nextLong(1L, 100L);
    assertTrue(
      storage.addPackage(
        ImmutablePackage.<Product>builder().amount(amount).product(product).build()
      )
        .isSuccess()
    );
    assertEquals(Some(amount),storage.products().get(product.name()));
  }

  @Test
  public void testRemoveProduct() {
    Storage storage = new Storage(wayfarer);
    assertTrue(storage.addProduct(product, 2L).isSuccess());
    assertTrue(storage.removeProduct(product, 1L).isSuccess());
    assertEquals(Some(1L),storage.products().get(product.name()));
  }

  @Test
  public void testFailureOnRemovingMoreThanExists() {
    Storage storage = new Storage(wayfarer);
    assertTrue(storage.addProduct(product, 2L).isSuccess());
    assertTrue(storage.removeProduct(product, 3L).isFailure());
  }

  @Test
  public void testFailureOnNonExistingProducts() {
    Storage storage = new Storage(wayfarer);
    assertTrue(storage.addProduct(product, 2L).isSuccess());
    assertTrue(
      storage.removeProduct(
        new Product() {

          @Override
          public String name() {
            return "AnotherProduct";
          }
        },
        1L
      )
        .isFailure()
    );
  }
}
