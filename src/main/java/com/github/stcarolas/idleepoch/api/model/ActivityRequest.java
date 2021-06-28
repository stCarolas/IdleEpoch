package com.github.stcarolas.idleepoch.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableActivityRequest.class)
@JsonDeserialize(
  as = ImmutableActivityRequest.class,
  builder = ImmutableActivityRequest.Builder.class
)
@Immutable
public interface ActivityRequest {
  ActivityType type();
}
