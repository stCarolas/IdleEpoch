package com.github.stcarolas.idleepoch.domain.activity.mining.mines;

import com.github.stcarolas.idleepoch.domain.activity.mining.MineImpl;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;

import org.immutables.value.Value.Immutable;

@Immutable
public abstract class CopperMine extends MineImpl {

  @Override
  public Long laborIntensity() {
    return 30L;
  }

  @Override
  public Ore product() {
    return Copper.of();
  }
}
