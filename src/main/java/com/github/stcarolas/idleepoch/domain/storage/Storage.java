package com.github.stcarolas.idleepoch.domain.storage;

import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;
import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.product.Pack;

public interface Storage {
  String ownerId();

  Try<?> addPack(Pack<? extends Product> pack);
  Try<List<Pack<Product>>> products();
  Try<Option<Pack<Product>>> findPackOf(Product product);
}
