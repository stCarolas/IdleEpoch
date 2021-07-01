package com.github.stcarolas.idleepoch.domain.product.storage;

import javax.inject.Named;
import static io.vavr.API.*;

@Named("StorageFactory")
public class StorageFactory {

  public Storage create(String ownerId){
    return ImmutableStorageImpl.builder().build();
  }

}
