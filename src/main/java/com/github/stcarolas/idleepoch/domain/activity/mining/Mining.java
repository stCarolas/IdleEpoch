package com.github.stcarolas.idleepoch.domain.activity.mining;

import javax.inject.Inject;
import com.github.stcarolas.enrichedbeans.annotations.Assisted;
import com.github.stcarolas.idleepoch.domain.activity.Activity;
import com.github.stcarolas.idleepoch.domain.scheduler.Timer;
import com.github.stcarolas.idleepoch.domain.villager.Villager;
import org.immutables.value.Value.Immutable;

@Immutable
@Assisted(useBuilder = true, assistAllInjectedFields = true)
public abstract class Mining implements Activity {
  private final Long DEFAULT_PRODUCTIVITY = 1L;

  @Inject
  abstract Timer timer();

  abstract public Mine mine();

  abstract public Villager miner();

  @Override
  public void tick() {
    mine().mine(DEFAULT_PRODUCTIVITY).forEach(pack -> miner().give(pack));
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
