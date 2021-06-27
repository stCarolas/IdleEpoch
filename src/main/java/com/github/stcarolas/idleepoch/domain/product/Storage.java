package com.github.stcarolas.idleepoch.domain.product;

import io.vavr.collection.Map;
import io.vavr.control.Try;
import static io.vavr.API.*;

public class Storage {
  private Map<String, Long> products = Map();

  public synchronized Try<?> addProduct(Product product, Long amount) {
    return products.get(product.name())
      .map(count -> count + amount)
      .orElse(Some(amount))
      .toTry()
      .map(count -> products.put(product.name(), count))
      .andThen(this::updateProducts);
  }

  public synchronized Try<?> removeProduct(Product product, Long amount) {
    return products.get(product.name())
      .toTry()
      .map(count -> count - amount)
      .filter(count -> count >= 0L)
      .map(
        count -> count == 0L ? products.remove(product.name())
          : products.put(product.name(), count)
      )
      .andThen(this::updateProducts);
  }

  private void updateProducts(Map<String, Long> products) {
    this.products = products;
  }

  public Map<String, Long> products() {
    return products;
  }
}
