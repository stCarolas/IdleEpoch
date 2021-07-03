package  com.github.stcarolas.idleepoch.domain.product;

import com.github.stcarolas.idleepoch.domain.product.ore.Copper;

import org.apache.commons.lang3.RandomUtils;

public class PackTestBuilder {

  Long amount;
  Product product;

  public PackTestBuilder amount(Long amount) {
    this.amount = amount;
    return this;
  }

  public PackTestBuilder product(Product product) {
    this.product = product;
    return this;
  }

  public Pack<Product> build(){
    return ImmutablePack.<Product>builder().product(product).amount(amount).build();
  }

  public static PackTestBuilder randomPack(){
    return new PackTestBuilder()
      .amount(RandomUtils.nextLong())
      .product(Copper.of());// todo randomize product
  }
  
}
