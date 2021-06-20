package  com.github.stcarolas.idleepoch.domain.activity;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import io.vavr.Function3;
import io.vavr.collection.List;
import static io.vavr.API.*;

public class Timer implements Runnable {

  private List<Tickable> activities = List();

  public Timer(Function3<Runnable, Long, TimeUnit, ScheduledFuture<?>> scheduler){
    scheduler.apply(this, 1L, TimeUnit.SECONDS);
  }

  public synchronized void addActivity(Tickable activity){
    activities = activities.append(activity);
  }

  public synchronized void removeActivity(Tickable activity){
    activities = activities.remove(activity);
  }

  @Override
  public void run(){
    activities.forEach(Tickable::tick);
  }

}
