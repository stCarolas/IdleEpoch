package  com.github.stcarolas.idleepoch.domain.product;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

@Immutable public interface Package<T> {
  @Parameter Long amount();
  @Parameter T product();
}
