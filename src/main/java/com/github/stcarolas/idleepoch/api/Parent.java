package  com.github.stcarolas.idleepoch.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(as = ImmutableChild.class)
@JsonDeserialize(as = ImmutableChild.class,builder = ImmutableChild.Builder.class)
public interface Parent {

  @JsonProperty("parentTest")
  public String test();

}
