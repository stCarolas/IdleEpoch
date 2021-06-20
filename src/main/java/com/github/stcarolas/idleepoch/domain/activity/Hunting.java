package  com.github.stcarolas.idleepoch.domain.activity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableHunting.class)
@JsonDeserialize(as = ImmutableHunting.class,builder = ImmutableHunting.Builder.class)
@Immutable public interface Hunting extends Activity {

}
