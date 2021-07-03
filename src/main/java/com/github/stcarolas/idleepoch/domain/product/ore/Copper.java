package com.github.stcarolas.idleepoch.domain.product.ore;

import org.immutables.value.Value.Immutable;

@Immutable(singleton = true)
public abstract class Copper implements Ore {

  public String name() {
    return "Copper";
  }

  public static Copper of(){
    return ImmutableCopper.of();
  }

}
