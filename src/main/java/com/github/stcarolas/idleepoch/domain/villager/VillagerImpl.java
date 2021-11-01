package com.github.stcarolas.idleepoch.domain.villager;

import com.github.stcarolas.enrichedbeans.annotations.Assisted;
import com.github.stcarolas.idleepoch.domain.activity.mining.MiningFactory;
import com.github.stcarolas.idleepoch.domain.product.Pack;
import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;
import io.vavr.control.Try;
import static io.vavr.API.*;

import javax.inject.Inject;

@Immutable
@VavrEncodingEnabled
@Assisted(useBuilder = true)
public abstract class VillagerImpl extends Villager {
  private static final Logger log = LogManager.getLogger();

  @Inject abstract MiningFactory miningFactory();

  @Override
  public Try<Villager> give(Pack<? extends Product> pack) {
    return storage().addPack(pack).map(it -> this);
  }

  @Override
  public Try<Villager> mine(Ore ore) {
    return Success(this);
  }
}
