package  com.github.stcarolas.idleepoch.domain.activity;

public interface Activity extends Tickable {

  default public void start(){}
  default public void stop(){}

}
