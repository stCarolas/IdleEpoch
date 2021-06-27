package com.github.stcarolas.idleepoch.domain.wayfarer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.idleepoch.domain.activity.Activity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.immutables.value.Value.Immutable;
import io.vavr.control.Option;
import static io.vavr.API.*;

@JsonSerialize(as = ImmutableWayfarer.class)
@JsonDeserialize(as = ImmutableWayfarer.class, builder = ImmutableWayfarer.Builder.class)
@Immutable
public abstract class Wayfarer {
  private static final Logger log = LogManager.getLogger();
  private Option<Activity> activity;

  public void setActivity(Activity activity) {
    this.activity = Option(activity);
  }

  public Option<Activity> getActivity() {
    return activity;
  }
}
