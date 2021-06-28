package com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import com.github.stcarolas.idleepoch.domain.product.ore.Stone;

public class StoneMine extends MineWithOreAndProgress {
  private static final Stone stone = new Stone();

  @Override
  protected Long laborIntensity() {
    return 30L;
  }

  @Override
  protected Ore product() {
    return stone;
  }
}

