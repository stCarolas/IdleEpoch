package  com.github.stcarolas.idleepoch.domain.activity;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.enrichedbeans.annotations.Assisted;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableFishing.class)
@JsonDeserialize(
  as = ImmutableFishing.class,
  builder = ImmutableFishing.Builder.class
)
@Assisted(useBuilder = true)
@Immutable public interface Fishing extends Activity {
  abstract Target target();
  @Inject abstract public Timer timer();

  public static enum Target{
    ANCHOVY,SHRIMP,CARP
  }

}
