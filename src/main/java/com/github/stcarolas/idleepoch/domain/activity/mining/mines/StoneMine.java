package com.github.stcarolas.idleepoch.domain.activity.mining.mines;

import com.github.stcarolas.idleepoch.domain.activity.mining.MineImpl;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import com.github.stcarolas.idleepoch.domain.product.ore.Stone;

import org.immutables.value.Value.Immutable;

@Immutable
public abstract class StoneMine extends MineImpl {
  private static final Stone stone = new Stone();

  @Override
  public Long laborIntensity() {
    return 30L;
  }

  @Override
  public Ore product() {
    return stone;
  }
}

