package com.github.stcarolas.idleepoch.domain.activity.mining;

import javax.inject.Inject;
import javax.inject.Named;
import com.github.stcarolas.idleepoch.domain.activity.mining.mines.ImmutableCopperMine;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import io.vavr.control.Option;
import static io.vavr.API.*;
import java.util.UUID;

@Named("MineFactory")
public class MineFactory {

  @Inject
  PlatformTransactionManager transactionManager;

  @Inject
  JdbcTemplate jdbcTemplate;

  public Option<Mine> of(Ore ore) {
    String id = UUID.randomUUID().toString();
    if (ore instanceof Copper) {
      return Some(
        ImmutableCopperMine.builder()
          .id(id)
          .jdbc(jdbcTemplate)
          .transactionTemplate(new TransactionTemplate(transactionManager))
          .build()
      );
    }
    return None();
  }

  public Mine of(String id) {
    return ImmutableCopperMine.builder()
      .id(id)
      .jdbc(jdbcTemplate)
      .transactionTemplate(new TransactionTemplate(transactionManager))
      .build();
  }
}
