package com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.ore.Ore;

import io.vavr.control.Try;

import com.github.stcarolas.idleepoch.domain.product.Pack;

public abstract class Mine {

  abstract public String id();

  abstract public Long laborIntensity();

  abstract public Ore product();

  abstract public Try<Pack<Ore>> mine(Long progress);
}
