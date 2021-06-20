package  com.github.stcarolas.idleepoch.domain.activity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableFishing.class)
@JsonDeserialize(as = ImmutableFishing.class,builder = ImmutableFishing.Builder.class)
@Immutable public interface Fishing extends Activity {

}
