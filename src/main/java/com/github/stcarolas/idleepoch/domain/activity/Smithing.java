package  com.github.stcarolas.idleepoch.domain.activity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableSmithing.class)
@JsonDeserialize(as = ImmutableSmithing.class,builder = ImmutableSmithing.Builder.class)
@Immutable public interface Smithing extends Activity {

}
