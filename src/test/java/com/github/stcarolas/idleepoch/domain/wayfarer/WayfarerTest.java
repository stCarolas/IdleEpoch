package com.github.stcarolas.idleepoch.domain.wayfarer;

import org.junit.jupiter.api.Test;
import com.github.stcarolas.idleepoch.domain.activity.ImmutableFishing;
import com.github.stcarolas.idleepoch.domain.activity.ImmutableWoodcutting;
import com.github.stcarolas.idleepoch.domain.activity.Timer;
import com.github.stcarolas.idleepoch.domain.activity.Woodcutting;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WayfarerTest {
  Wayfarer wayfarer = ImmutableWayfarer.builder().build();
  ImmutableFishing fishing = ImmutableFishing.builder().timer(mock(Timer.class)).build();
  ImmutableWoodcutting woodcutting = ImmutableWoodcutting.builder()
    .target(Woodcutting.Target.OAK)
    .timer(mock(Timer.class))
    .build();

  @Test
  public void testSettingActivity() {
    wayfarer.setActivity(woodcutting);
    assertTrue(wayfarer.getActivity().exists(woodcutting::equals));

    wayfarer.setActivity(fishing);
    assertTrue(wayfarer.getActivity().exists(fishing::equals));
  }
}
