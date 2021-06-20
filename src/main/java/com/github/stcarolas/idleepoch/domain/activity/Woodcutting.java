package com.github.stcarolas.idleepoch.domain.activity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableWoodcutting.class)
@JsonDeserialize(as = ImmutableWoodcutting.class, builder = ImmutableWoodcutting.Builder.class)
@Immutable public abstract class Woodcutting implements Activity {

  private Target target = Target.OAK;

  public void setTarget(Target target){
    this.target = target;
  }

  public static enum Target{
    OAK,PINE,MAPLE
  }

  @Override
  public void tick(){
  }

}
