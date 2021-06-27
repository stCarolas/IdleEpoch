package com.github.stcarolas.idleepoch.domain.product.wood;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.idleepoch.domain.product.Product;
import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutablePine.class)
@JsonDeserialize(as = ImmutablePine.class, builder = ImmutablePine.Builder.class)
@Immutable
public abstract class Pine implements Wood, Product {}
