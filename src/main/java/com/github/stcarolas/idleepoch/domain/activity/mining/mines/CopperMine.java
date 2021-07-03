package com.github.stcarolas.idleepoch.domain.activity.mining.mines;

import com.github.stcarolas.idleepoch.domain.activity.mining.MineImpl;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;

public class CopperMine extends MineImpl {

  @Override
  protected Long laborIntensity() {
    return 30L;
  }

  @Override
  protected Ore product() {
    return Copper.of();
  }
}
