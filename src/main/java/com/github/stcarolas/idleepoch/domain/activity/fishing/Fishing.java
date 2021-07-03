package com.github.stcarolas.idleepoch.domain.activity.fishing;

import javax.inject.Inject;
import com.github.stcarolas.enrichedbeans.annotations.Assisted;
import com.github.stcarolas.idleepoch.domain.activity.Activity;
import com.github.stcarolas.idleepoch.domain.scheduler.Timer;
import org.immutables.value.Value.Immutable;

@Assisted(useBuilder = true)
@Immutable
public interface Fishing extends Activity {
  abstract Target target();

  @Inject
  abstract public Timer timer();

  public static enum Target {
    ANCHOVY, SHRIMP, CARP;
  }
}
