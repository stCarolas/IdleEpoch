package com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import com.github.stcarolas.idleepoch.domain.product.Package;

public interface Mine {
  Package<Ore> mine(Long progress);
}
