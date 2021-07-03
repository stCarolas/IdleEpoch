package com.github.stcarolas.idleepoch.domain.activity.mining;

import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import com.github.stcarolas.idleepoch.domain.product.Package;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import static org.junit.jupiter.api.Assertions.*;

public class MineWithOreAndProgressTest {
  private static final Logger log = LogManager.getLogger();

  @Test
  public void testReturnCreatedPackage() {
    int productsAmount = RandomUtils.nextInt();
    Package<Ore> mineResult = new TestMine().mine(productsAmount * TestMine.LABOR_INTENSITY);
    assertEquals(productsAmount, mineResult.amount());
    assertEquals(TestMine.PRODUCT, mineResult.product());
  }

  @Test
  public void testReturnZeroOreWhenMiningNotEnough() {
    CopperMine mine = new CopperMine();
    Package<Ore> mineResult = mine.mine(0L);
    assertEquals(0, mineResult.amount());
  }

  @Test
  public void testCummulativeProgress() {
    TestMine mine = new TestMine();
    Package<Ore> firstMineResult = mine.mine(TestMine.LABOR_INTENSITY / 2);
    Package<Ore> secondMineResult = mine.mine(TestMine.LABOR_INTENSITY / 2);
    assertEquals(0, firstMineResult.amount());
    assertEquals(1, secondMineResult.amount());
  }

  public static class TestMine extends MineWithOreAndProgress {
    public static final long LABOR_INTENSITY = 30L;
    public static final Copper PRODUCT = Copper.of();

    @Override
    protected Long laborIntensity() {
      return LABOR_INTENSITY;
    }

    @Override
    protected Ore product() {
      return PRODUCT;
    }
  }
}
