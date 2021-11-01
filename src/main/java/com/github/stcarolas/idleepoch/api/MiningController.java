package com.github.stcarolas.idleepoch.api;

import com.github.stcarolas.idleepoch.domain.activity.mining.MiningFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wayfarer/{id}/activity/mining")
public class MiningController {
  static final Logger log = LogManager.getLogger();
  MiningFactory factory;

  public MiningController(MiningFactory factory){
    this.factory = factory;
  }

  @PutMapping
  public void create(@PathVariable("id") String wayfarerId) {
  }
}
