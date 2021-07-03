package com.github.stcarolas.idleepoch.domain.villager;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import com.github.stcarolas.idleepoch.domain.storage.Storage;
import com.github.stcarolas.idleepoch.domain.storage.StorageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named("WayfarerFactory")
public class VillagerFactory {
  static final Logger log = LogManager.getLogger();
  private StorageFactory factory;

  @Inject
  public VillagerFactory(StorageFactory factory){
    this.factory = factory;
  }

  public Villager create() {
    String id = UUID.randomUUID().toString();
    Storage storage = factory.of(id);
    return ImmutableVillagerImpl.builder()
      .id(id)
      .storage(storage)
      .build();
  }

}
