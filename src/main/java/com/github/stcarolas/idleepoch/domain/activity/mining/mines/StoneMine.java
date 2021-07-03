package com.github.stcarolas.idleepoch.domain.activity.mining.mines;

import com.github.stcarolas.idleepoch.domain.activity.mining.MineImpl;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import com.github.stcarolas.idleepoch.domain.product.ore.Stone;

public class StoneMine extends MineImpl {
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

