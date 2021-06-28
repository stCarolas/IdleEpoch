package com.github.stcarolas.idleepoch.domain.wayfarer;

import org.junit.jupiter.api.Test;
import com.github.stcarolas.idleepoch.domain.activity.ImmutableFishing;
import com.github.stcarolas.idleepoch.domain.activity.ImmutableWoodcutting;
import com.github.stcarolas.idleepoch.domain.activity.Timer;
import com.github.stcarolas.idleepoch.domain.activity.Woodcutting;
import com.github.stcarolas.idleepoch.domain.activity.Fishing;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static io.vavr.API.*;

public class WayfarerTest {
  Wayfarer wayfarer = ImmutableWayfarer.builder().build();
  ImmutableFishing fishing = ImmutableFishing.builder()
    .target(Fishing.Target.SHRIMP)
    .timer(mock(Timer.class))
    .build();
  ImmutableWoodcutting woodcutting = ImmutableWoodcutting.builder()
    .target(Woodcutting.Target.OAK)
    .timer(mock(Timer.class))
    .build();

  @Test
  public void testSettingActivity() {
    wayfarer.setActivity(woodcutting);
    assertEquals(Some(woodcutting), wayfarer.getActivity());

    wayfarer.setActivity(fishing);
    assertEquals(Some(fishing), wayfarer.getActivity());
  }
}
