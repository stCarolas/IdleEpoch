package com.github.stcarolas.idleepoch.domain.product.storage;

import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;
import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.product.Package;

public interface Storage {
  String ownerId();

  Try<?> addPackage(Package<? extends Product> pack);
  Try<List<Package<Product>>> products();
  Try<Option<Package<Product>>> findPackageOf(Product product);
}
