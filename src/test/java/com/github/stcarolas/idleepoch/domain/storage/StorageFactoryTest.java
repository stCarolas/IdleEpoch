package  com.github.stcarolas.idleepoch.domain.storage;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.BDDMockito.*;

import com.github.stcarolas.idleepoch.domain.product.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

public class StorageFactoryTest {
  JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
  ProductFactory productFactory = mock(ProductFactory.class);

  @Test
  public void createWithRightOwnerId(){
    StorageFactory factory = new StorageFactory(jdbcTemplate, productFactory);
    String ownerId = RandomStringUtils.random(10);
    Storage storage = factory.of(ownerId);
    assertEquals(ownerId,storage.ownerId());
  }
}
