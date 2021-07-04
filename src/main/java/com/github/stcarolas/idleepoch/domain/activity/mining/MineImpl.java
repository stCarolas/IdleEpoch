package com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.Pack;
import com.github.stcarolas.idleepoch.domain.product.ImmutablePack;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import io.vavr.control.Try;
import static io.vavr.API.*;

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

  private Long getCurrentProgress() {
    return jdbc().queryForObject("select progress from mines where id = ?", Long.class, id());
  }

  private void setCurrentProgress(Long progress) {
    jdbc().update("update mines set progress = ? where id = ?", progress, id());
  }
}
