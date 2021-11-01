package  com.github.stcarolas.idleepoch.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableAnotherChild.class)
@JsonDeserialize(as = ImmutableAnotherChild.class,builder = ImmutableAnotherChild.Builder.class)
@Immutable public interface AnotherChild extends Parent {

  @JsonProperty("anotherChildTest")
  public String test();

}
