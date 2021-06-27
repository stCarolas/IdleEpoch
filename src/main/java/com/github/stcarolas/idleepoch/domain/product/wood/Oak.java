package com.github.stcarolas.idleepoch.domain.product.wood;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.idleepoch.domain.product.Product;
import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableOak.class)
@JsonDeserialize(as = ImmutableOak.class, builder = ImmutableOak.Builder.class)
@Immutable
public abstract class Oak implements Wood, Product {}
