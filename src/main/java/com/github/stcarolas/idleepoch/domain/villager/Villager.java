package com.github.stcarolas.idleepoch.domain.villager;

import com.github.stcarolas.idleepoch.domain.activity.Activity;
import com.github.stcarolas.idleepoch.domain.product.storage.Storage;

import io.vavr.control.Option;

public abstract class Villager {

  abstract String id();
  abstract Storage storage();
  abstract Option<Activity> activity();

}
