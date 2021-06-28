package  com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.Package;
import com.github.stcarolas.idleepoch.domain.product.ImmutablePackage;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;

public abstract class MineWithOreAndProgress implements Mine {

  private Long progress = 0L;

  @Override
  public Package<Ore> mine(Long progress) {
    long totalProgress = 0L;
    synchronized(this) {
      totalProgress = this.progress + progress;
      this.progress = totalProgress % laborIntensity();
    }

    return ImmutablePackage.<Ore>builder()
      .amount(totalProgress/laborIntensity())
      .product(product())
      .build();
  }

  abstract protected Long laborIntensity();
  abstract protected Ore product();
}
