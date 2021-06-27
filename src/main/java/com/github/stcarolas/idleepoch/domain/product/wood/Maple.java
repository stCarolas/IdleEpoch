package com.github.stcarolas.idleepoch.domain.product.wood;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.idleepoch.domain.product.Product;
import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableMaple.class)
@JsonDeserialize(as = ImmutableMaple.class, builder = ImmutableMaple.Builder.class)
@Immutable
public abstract class Maple implements Wood, Product {}
