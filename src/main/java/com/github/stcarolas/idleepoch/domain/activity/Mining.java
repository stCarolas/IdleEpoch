package  com.github.stcarolas.idleepoch.domain.activity;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.stcarolas.enrichedbeans.annotations.Assisted;

import org.immutables.value.Value.Immutable;

@JsonSerialize(as = ImmutableMining.class)
@JsonDeserialize(as = ImmutableMining.class,builder = ImmutableMining.Builder.class)
@Assisted(useBuilder = true)
@Immutable public interface Mining {
  abstract Target target();
  @Inject abstract public Timer timer();

  @Override
  public void tick(){}

  @Override
  public void start(){
    timer().addActivity(this);
  }

  @Override
  public void stop(){
    timer().removeActivity(this);
  }

  public static enum Target{
    COPPER, CLAY, STONE, IRON
  }

}
