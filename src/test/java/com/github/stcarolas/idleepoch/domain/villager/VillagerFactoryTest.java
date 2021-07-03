package  com.github.stcarolas.idleepoch.domain.villager;

import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;

import com.github.stcarolas.idleepoch.domain.product.storage.Storage;
import com.github.stcarolas.idleepoch.domain.product.storage.StorageFactory;

import static org.junit.jupiter.api.Assertions.*;

public class VillagerFactoryTest {
  StorageFactory storageFactory = mock(StorageFactory.class);
  Storage storage = mock(Storage.class);

  // todo fix test
  @Test
  public void createWithRightIdInStorage() {
    when(storageFactory.of(any())).thenReturn(storage);
    VillagerFactory villagerFactory = new VillagerFactory(storageFactory);
    Villager villager = villagerFactory.create();
    verify(storageFactory).of("asdf");
  }
}
