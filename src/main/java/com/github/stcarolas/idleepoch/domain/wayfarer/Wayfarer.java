package com.github.stcarolas.idleepoch.domain.wayfarer;

import com.github.stcarolas.idleepoch.domain.activity.Activity;
import com.github.stcarolas.idleepoch.domain.product.storage.Storage;

import io.vavr.control.Option;

public abstract class Wayfarer {

  abstract String id();
  abstract Storage storage();
  abstract Option<Activity> activity();

}
