package com.github.stcarolas.idleepoch.domain.activity.mining;

import javax.inject.Inject;
import com.github.stcarolas.enrichedbeans.annotations.Assisted;
import com.github.stcarolas.idleepoch.domain.activity.Activity;
import com.github.stcarolas.idleepoch.domain.activity.Timer;
import com.github.stcarolas.idleepoch.domain.product.storage.Storage;
import com.github.stcarolas.idleepoch.domain.wayfarer.Wayfarer;

import org.immutables.value.Value.Immutable;

@Assisted(useBuilder = true, assistAllInjectedFields = true)
@Immutable
public abstract class Mining implements Activity {
  private final Long DEFAULT_PRODUCTIVITY = 1L;

  @Inject
  abstract public Timer timer();

  abstract public Storage storage();
  abstract public Mine mine();
  abstract public Wayfarer miner();

  @Override
  public void tick() {
    storage().addPackage(mine().mine(DEFAULT_PRODUCTIVITY));
  }

  @Override
  public void start() {
    timer().addActivity(this);
  }

  @Override
  public void stop() {
    timer().removeActivity(this);
  }
}
