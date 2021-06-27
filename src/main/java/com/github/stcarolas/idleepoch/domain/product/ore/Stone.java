package com.github.stcarolas.idleepoch.domain.product.ore;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.idleepoch.domain.product.Product;
import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableStone.class)
@JsonDeserialize(as = ImmutableStone.class, builder = ImmutableStone.Builder.class)
@Immutable
public abstract class Stone implements Ore, Product {

  public String name() {
    return "Stone";
  }

  public Long tickCost() {
    return 15L;
  }
}
