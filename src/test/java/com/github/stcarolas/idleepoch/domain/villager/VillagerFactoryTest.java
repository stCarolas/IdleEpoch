package com.github.stcarolas.idleepoch.domain.villager;

import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;
import com.github.stcarolas.idleepoch.domain.storage.Storage;
import com.github.stcarolas.idleepoch.domain.storage.StorageFactory;
import static org.junit.jupiter.api.Assertions.*;

public class VillagerFactoryTest {
  StorageFactory storageFactory   = mock(StorageFactory.class);
  Storage storage                 = mock(Storage.class);
  VillagerFactory villagerFactory = new VillagerFactory(storageFactory);

  @Test
  public void createWithStorage() {
    when(storageFactory.of(any())).thenReturn(storage);
    Villager villager = new VillagerFactory(storageFactory).create();
    assertEquals(storage, villager.storage());
  }

  @Test
  public void createWithRightIdInStorage() {
    when(storageFactory.of(any())).thenReturn(storage);
    Villager villager = new VillagerFactory(storageFactory).create();
    verify(storageFactory).of(villager.id());
  }
}
