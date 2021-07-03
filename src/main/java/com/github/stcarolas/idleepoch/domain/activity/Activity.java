package  com.github.stcarolas.idleepoch.domain.activity;

import com.github.stcarolas.idleepoch.domain.scheduler.Tickable;

public interface Activity extends Tickable {

  default public void start(){}
  default public void stop(){}

}
