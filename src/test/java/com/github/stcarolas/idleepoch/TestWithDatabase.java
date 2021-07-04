package  com.github.stcarolas.idleepoch;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.FileReader;

import javax.sql.DataSource;

public class TestWithDatabase {
  private DataSource datasource = initDB();
  private JdbcTemplate jdbc = jdbc(datasource);
  private PlatformTransactionManager transactionManager = transactionManager(datasource);

  private DataSource initDB() {
    try {
      JdbcDataSource datasource = new JdbcDataSource();
      datasource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
      RunScript.execute(
        datasource.getConnection(),
        new FileReader(getClass().getClassLoader().getResource("schema.sql").getFile())
      );
      return datasource;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private JdbcTemplate jdbc(DataSource datasource) {
    return new JdbcTemplate(datasource);
  }

  private PlatformTransactionManager transactionManager(DataSource datasource) {
    return new DataSourceTransactionManager(datasource);
  }

  protected PlatformTransactionManager transactionManager(){
    return transactionManager;
  }

  protected DataSource datasource(){
    return datasource;
  }

  protected JdbcTemplate jdbc(){
    return jdbc;
  }
}
