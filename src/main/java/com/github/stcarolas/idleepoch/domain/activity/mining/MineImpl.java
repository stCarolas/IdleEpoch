package com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.Pack;
import com.github.stcarolas.idleepoch.domain.activity.mining.mines.ImmutableCopperMine;
import com.github.stcarolas.idleepoch.domain.product.ImmutablePack;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import io.vavr.control.Try;
import static io.vavr.API.*;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;

public abstract class MineImpl extends Mine {

  abstract public TransactionTemplate transactionTemplate();

  abstract public JdbcTemplate jdbc();

  @Override
  public Try<Pack<Ore>> mine(final Long progress) {
    return Try(
      () -> transactionTemplate()
        .execute(
          new TransactionCallback<Pack<Ore>>() {

            @Override
            public Pack<Ore> doInTransaction(TransactionStatus status) {
              long totalProgress = getCurrentProgress() + progress;
              setCurrentProgress(totalProgress % laborIntensity());
              return ImmutablePack.of(totalProgress / laborIntensity(), product());
            }
          }
        )
    );
  }

  private Try<Mine> create() {
    return Try(
      () -> jdbc()
        .update(
          "insert into mines (id,ore_name,progress,labor_intensity)) values()",
          id(),
          product().name(),
          0L,
          laborIntensity()
        )
    )
      .map(it -> this);
  }

  private Long getCurrentProgress() {
    return jdbc()
      .queryForObject("select progress from mines where id = ?", Long.class, id());
  }

  private void setCurrentProgress(Long progress) {
    jdbc().update("update mines set progress = ? where id = ?", progress, id());
  }

  @Named("MineFactory")
  public static class MineFactory {
    private PlatformTransactionManager transactionManager;
    private JdbcTemplate jdbcTemplate;

    @Inject
    public MineFactory(
      JdbcTemplate jdbcTemplate,
      PlatformTransactionManager transactionManager
    ) {
      this.jdbcTemplate = jdbcTemplate;
      this.transactionManager = transactionManager;
    }

    public Try<Mine> of(Ore ore) {
      String id = UUID.randomUUID().toString();
      if (ore instanceof Copper) {
        return ((MineImpl) ImmutableCopperMine.builder()
          .id(id)
          .jdbc(jdbcTemplate)
          .transactionTemplate(new TransactionTemplate(transactionManager))
          .build())
          .create();
      }
      return Failure(new RuntimeException("No mine for such ore"));
    }

    public Mine of(String id) {
      return ImmutableCopperMine.builder()
        .id(id)
        .jdbc(jdbcTemplate)
        .transactionTemplate(new TransactionTemplate(transactionManager))
        .build();
    }
  }
}
