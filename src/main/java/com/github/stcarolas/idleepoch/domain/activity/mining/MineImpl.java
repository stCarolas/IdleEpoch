package com.github.stcarolas.idleepoch.domain.activity.mining;

import com.github.stcarolas.idleepoch.domain.product.Pack;
import com.github.stcarolas.idleepoch.domain.product.ImmutablePack;
import com.github.stcarolas.idleepoch.domain.product.ore.Ore;

import io.vavr.control.Try;

import static io.vavr.API.*;

public abstract class MineImpl extends Mine {
  private Long progress = 0L;

  //abstract JdbcTemplate jdbc();
  //abstract ProductFactory productFactory();

  @Override
  public Try<Pack<Ore>> mine(Long progress) {
    //long totalProgress = 0L;
    //synchronized (this) {
      //totalProgress = this.progress + progress;
      //this.progress = totalProgress % laborIntensity();
    //}

    //return Try(
      //() -> jdbc()
        //.update(
          //"insert into storage_products (villager_id, name, amount) values (?, ?, ?)",
          //ownerId(),
          //pack.product().name(),
          //pack.amount()
        //)
    //)
      //.onFailure(log::error);
    return Success(ImmutablePack.of(0L, product()));
  }
}
