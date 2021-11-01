package com.github.stcarolas.idleepoch.domain.villager;

import com.github.stcarolas.idleepoch.domain.product.Pack;
import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import com.github.stcarolas.idleepoch.domain.storage.Storage;

import io.vavr.control.Try;

public abstract class Villager {

  protected abstract String id();
  protected abstract Storage storage();

  public abstract Try<Villager> give(Pack<? extends Product> pack);
  public abstract Try<Villager> mine(Ore ore);

}
