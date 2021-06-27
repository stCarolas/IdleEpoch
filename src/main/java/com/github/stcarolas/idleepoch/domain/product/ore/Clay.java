package com.github.stcarolas.idleepoch.domain.product.ore;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.idleepoch.domain.product.Product;
import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableClay.class)
@JsonDeserialize(as = ImmutableClay.class, builder = ImmutableClay.Builder.class)
@Immutable
public abstract class Clay implements Ore, Product {

  public String name() {
    return "Clay";
  }

  public Long tickCost() {
    return 10L;
  }
}
