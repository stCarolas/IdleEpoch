package com.github.stcarolas.idleepoch.domain.product.ore;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.idleepoch.domain.product.Product;
import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableCopper.class)
@JsonDeserialize(as = ImmutableCopper.class, builder = ImmutableCopper.Builder.class)
@Immutable
public abstract class Copper implements Ore, Product {

  public String name() {
    return "Copper";
  }

  public Long tickCost() {
    return 30L;
  }
}
