package com.github.stcarolas.idleepoch.domain.activity.woodcutting;

import javax.inject.Inject;

import com.github.stcarolas.enrichedbeans.annotations.Assisted;
import com.github.stcarolas.idleepoch.domain.activity.Activity;
import com.github.stcarolas.idleepoch.domain.scheduler.Timer;

import org.immutables.value.Value.Immutable;

@Assisted(useBuilder = true)
@Immutable public abstract class Woodcutting implements Activity {

  abstract Target target();
  @Inject abstract public Timer timer();

  @Override
  public void tick(){}

  @Override
  public void start(){
    timer().addActivity(this);
  }

  @Override
  public void stop(){
    timer().removeActivity(this);
  }

  public static enum Target{
    OAK,PINE,MAPLE
  }

}
