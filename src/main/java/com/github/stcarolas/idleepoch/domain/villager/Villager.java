package com.github.stcarolas.idleepoch.domain.villager;

import com.github.stcarolas.idleepoch.domain.activity.Activity;
import com.github.stcarolas.idleepoch.domain.product.Pack;
import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.storage.Storage;

import io.vavr.control.Option;
import io.vavr.control.Try;

public abstract class Villager {

  abstract String id();
  abstract Storage storage();
  abstract Option<Activity> activity();

  public abstract Try<Villager> give(Pack<? extends Product> pack);

}
