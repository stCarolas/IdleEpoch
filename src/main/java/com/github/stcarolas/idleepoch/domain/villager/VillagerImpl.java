package com.github.stcarolas.idleepoch.domain.villager;

import com.github.stcarolas.idleepoch.domain.product.Pack;
import com.github.stcarolas.idleepoch.domain.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;
import io.vavr.control.Try;

@Immutable
@VavrEncodingEnabled
public abstract class VillagerImpl extends Villager {
  static final Logger log = LogManager.getLogger();

  public Try<Villager> give(Pack<? extends Product> pack) {
    return storage().addPack(pack).map(it -> this);
  }
}
