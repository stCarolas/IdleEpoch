package  com.github.stcarolas.idleepoch.domain.product;

import com.github.stcarolas.idleepoch.domain.product.ore.Clay;
import com.github.stcarolas.idleepoch.domain.product.ore.Copper;
import com.github.stcarolas.idleepoch.domain.product.ore.Stone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.vavr.collection.List;
import io.vavr.control.Option;

import static io.vavr.API.*;

public class ProductFactory {
  static final Logger log = LogManager.getLogger();
  private List<Product> products = List(Copper.of(), new Clay(), new Stone());

  public Option<Product> byName(String name){
    return products.find(product -> product.name().equals(name));
  }
}
