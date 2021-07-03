package com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.ore.Ore;

import io.vavr.control.Try;

import com.github.stcarolas.idleepoch.domain.product.Pack;

public abstract class Mine {

  //abstract protected String id();

  abstract protected Long laborIntensity();

  abstract protected Ore product();

  abstract Try<Pack<Ore>> mine(Long progress);
}
