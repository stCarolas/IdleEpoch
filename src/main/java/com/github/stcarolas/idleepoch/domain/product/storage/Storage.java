package com.github.stcarolas.idleepoch.domain.product.storage;

import io.vavr.control.Try;
import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.product.Package;

public abstract class Storage {

  abstract String ownerId();

  public abstract Try<?> addPackage(Package<? extends Product> pack);
}
