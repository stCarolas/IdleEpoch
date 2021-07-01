package com.github.stcarolas.idleepoch.domain.wayfarer;

import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named("WayfarerFactory")
public class WayfarerFactory {
  static final Logger log = LogManager.getLogger();

  public Wayfarer create() {
    return null;
    //Storage storage = new Storage();
    //Wayfarer wayfarer = new Wayfarer();
    //wayfarer.setStorage(storage);
    //storage.setOwner(wayfarer);
    //return wayfarer;
  }

}
