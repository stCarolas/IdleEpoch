package com.github.stcarolas.idleepoch.domain.activity;

import org.junit.jupiter.api.Test;
import io.vavr.Function3;
import static org.mockito.BDDMockito.*;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimerTest {
  TestScheduler scheduler = new TestScheduler();
  Timer timer = new Timer(scheduler);

  @Test
  public void testAddActivity() {
    Tickable action = createScheduledActivity();
    scheduler.run();
    verify(action).tick();
  }

  @Test
  public void testRemoveActivity() {
    Tickable action = createScheduledActivity();
    timer.removeActivity(action);
    scheduler.run();
    verifyNoInteractions(action);
  }

  @Test
  public void testRunAllActivities() {
    Tickable action1 = createScheduledActivity();
    Tickable action2 = createScheduledActivity();
    scheduler.run();
    verify(action1).tick();
    verify(action2).tick();
  }

  @Test
  public void testRemoveActivityWhileOtherStillWorks() {
    Tickable action1 = createScheduledActivity();
    Tickable action2 = createScheduledActivity();
    timer.removeActivity(action1);
    scheduler.run();
    verify(action2).tick();
  }

  private Tickable createScheduledActivity() {
    Tickable action = mock(Tickable.class);
    timer.addActivity(action);
    return action;
  }

  public static class TestScheduler
    implements Function3<Runnable, Long, TimeUnit, ScheduledFuture<?>> {
    private static final long serialVersionUID = 1L;
    private Runnable runnable;

    @Override
    public ScheduledFuture<?> apply(Runnable runnable, Long time, TimeUnit timeUnit) {
      this.runnable = runnable;
      return mock(ScheduledFuture.class);
    }

    public void run() {
      runnable.run();
    }
  }
}
