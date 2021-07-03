package  com.github.stcarolas.idleepoch.domain.scheduler;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.vavr.Function3;

@Configuration
public class ScheduleConfiguration {

  @Bean 
  public Function3<Runnable, Long, TimeUnit, ScheduledFuture<?>> scheduler(){
    return new ScheduledThreadPoolExecutor(2)::schedule;
  }

}
