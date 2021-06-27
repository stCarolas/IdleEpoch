package com.github.stcarolas.idleepoch.domain.activity;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.enrichedbeans.annotations.Assisted;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableWoodcutting.class)
@JsonDeserialize(as = ImmutableWoodcutting.class, builder = ImmutableWoodcutting.Builder.class)
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
