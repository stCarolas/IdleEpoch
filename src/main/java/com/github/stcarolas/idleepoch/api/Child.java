package  com.github.stcarolas.idleepoch.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableChild.class)
@JsonDeserialize(as = ImmutableChild.class,builder = ImmutableChild.Builder.class)
@Immutable public interface Child extends Parent {

  @JsonProperty("childTest")
  public String test();

}
