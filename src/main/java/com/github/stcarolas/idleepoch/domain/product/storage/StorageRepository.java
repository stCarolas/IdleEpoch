package com.github.stcarolas.idleepoch.domain.product.storage;

import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import io.vavr.collection.List;
import io.vavr.control.Option;

@Named("StorageRepository")
public class StorageRepository {
  static final Logger log = LogManager.getLogger();

  private JdbcTemplate jdbc;

  @Inject
  public StorageRepository(JdbcTemplate jdbcTemplate) {
    this.jdbc = jdbcTemplate;
  }

  public Option<Storage> get(String id) {
    return List.ofAll(
      jdbc.query(
        String.format("select * from storage where id=%s",id),
        new BeanPropertyRowMapper<Storage>(Storage.class)
      )
    )
      .headOption();
  }
}
