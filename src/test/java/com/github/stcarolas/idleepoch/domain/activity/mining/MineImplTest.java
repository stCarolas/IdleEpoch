package com.github.stcarolas.idleepoch.domain.activity.mining;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.immutables.value.Value.Immutable;
import org.immutables.vavr.encodings.VavrEncodingEnabled;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.support.TransactionTemplate;
import static org.mockito.BDDMockito.*;
import java.util.Map;
import com.github.stcarolas.idleepoch.TestWithDatabase;
import com.github.stcarolas.idleepoch.domain.product.ImmutablePack;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import static org.junit.jupiter.api.Assertions.*;
import static io.vavr.API.*;

public class MineImplTest extends TestWithDatabase {
  String id = RandomStringUtils.random(10);
  long laborIntensity = RandomUtils.nextLong();
  Mine mine = ImmutableTestMineImpl.builder()
    .id(id)
    .laborIntensity(laborIntensity)
    .product(Copper.of())
    .jdbc(jdbc())
    .transactionTemplate(new TransactionTemplate(transactionManager()))
    .build();

  @Test
  public void handleNonFinishingProgress() {
    long progress = laborIntensity - 1;
    jdbc()
      .update(
        "insert into mines (id, ore_name, progress, labor_intensity) values (?,?,?,?)",
        id,
        Copper.of().name(),
        0L,
        laborIntensity
      );
    assertEquals(Success(ImmutablePack.of(0L, Copper.of())), mine.mine(progress));
    Map<String, Object> updated = jdbc()
      .queryForMap("select * from mines where id = ?", id);
    assertEquals(progress, updated.get("PROGRESS"));
  }

  @Test
  public void handleFinishingProgress() {
    long progress = laborIntensity - 1;
    long pastProgress = laborIntensity - 1;
    jdbc()
      .update(
        "insert into mines (id, ore_name, progress, labor_intensity) values (?,?,?,?)",
        id,
        Copper.of().name(),
        pastProgress,
        laborIntensity
      );
    assertEquals(
      Success(ImmutablePack.of((pastProgress + progress) / laborIntensity, Copper.of())),
      mine.mine(progress)
    );
    Map<String, Object> updated = jdbc()
      .queryForMap("select * from mines where id = ?", id);
    assertEquals((pastProgress + progress) % laborIntensity, updated.get("PROGRESS"));
  }
}

@Immutable
@VavrEncodingEnabled
abstract class TestMineImpl extends MineImpl {}
