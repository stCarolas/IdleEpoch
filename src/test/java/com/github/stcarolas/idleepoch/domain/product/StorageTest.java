package  com.github.stcarolas.idleepoch.domain.product;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.vavr.control.Option;

import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {
  Product product = new Product(){
    @Override
    public String name() {
      return "TestProduct";
    }
  };

  @Test
  public void testEmptyStorage() {
    assertTrue(new Storage().products().keySet().isEmpty());
  }

  @Test
  @Disabled
  public void testAddProduct() {
    Storage storage = new Storage();
    assertTrue(storage.addProduct(product, 2L).isSuccess());
    Option<Long> storedProductCount = storage.products().get(product.name());
    assertTrue(storedProductCount.isDefined());
    assertTrue(storedProductCount.exists(count -> count == 2L));
  }

  @Test
  public void testRemoveProduct() {
    Storage storage = new Storage();
    assertTrue(storage.addProduct(product, 2L).isSuccess());
    assertTrue(storage.removeProduct(product, 1L).isSuccess());
    Option<Long> storedProductCount = storage.products().get(product.name());
    assertTrue(storedProductCount.isDefined());
    assertTrue(storedProductCount.exists(count -> count == 1L));
  }

  @Test
  public void testFailureOnRemovingMoreThanExists() {
    Storage storage = new Storage();
    assertTrue(storage.addProduct(product, 2L).isSuccess());
    assertTrue(storage.removeProduct(product, 3L).isFailure());
  }

  @Test
  public void testFailureOnNonExistingProducts() {
    Storage storage = new Storage();
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
      ).isFailure()
    );
  }
  
}
