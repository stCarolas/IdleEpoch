package com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;

public class CopperMine extends MineWithOreAndProgress {
  private static final Copper copper = new Copper();

  @Override
  protected Long laborIntensity() {
    return 30L;
  }

  @Override
  protected Ore product() {
    return copper;
  }
}
