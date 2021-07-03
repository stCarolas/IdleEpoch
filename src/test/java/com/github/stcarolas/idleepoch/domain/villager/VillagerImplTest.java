package com.github.stcarolas.idleepoch.domain.villager;

import org.junit.jupiter.api.Test;
import io.vavr.control.Try;
import static org.mockito.BDDMockito.*;
import java.util.UUID;
import com.github.stcarolas.idleepoch.domain.product.Pack;
import com.github.stcarolas.idleepoch.domain.product.Product;
import com.github.stcarolas.idleepoch.domain.storage.Storage;
import static com.github.stcarolas.idleepoch.domain.product.PackTestBuilder.*;
import static org.junit.jupiter.api.Assertions.*;
import static io.vavr.API.*;

public class VillagerImplTest {
  Storage storage = mock(Storage.class);
  Villager villager = ImmutableVillagerImpl.builder()
    .id(UUID.randomUUID().toString())
    .storage(storage)
    .build();

  @Test
  public void storeGivenPackInStorage() {
    when(storage.addPack(any())).thenReturn(Success(null));
    Pack<Product> pack = randomPack().build();
    villager.give(pack);
    verify(storage).addPack(pack);
  }

  @Test
  public void returnFailureWhenStoreFailures() {
    RuntimeException exception = new RuntimeException();
    when(storage.addPack(any())).thenReturn(Failure(exception));
    Try<Villager> givingResult = villager.give(randomPack().build());
    assertTrue(givingResult.isFailure());
    assertEquals(exception, givingResult.getCause());
  }
}
