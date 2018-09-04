package ua.thydope.finalproject.component.account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import javax.sql.DataSource;

import ua.thydope.finalproject.component.api.DBDaoFactory;
import ua.thydope.finalproject.component.api.MapperRegistry;
import ua.thydope.finalproject.component.api.Service;

public class AccountService extends Service {
  public AccountService(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Returns optional role name of given credentials
   *
   * @param the username
   * @param the pwd
   * @return optional role name
   */
  public void authorize(Account account) {
    try (Connection connection = dataSource.getConnection()) {
      DBDaoFactory.use(connection);
      MapperRegistry.use(DBDaoFactory.getInstance());
      AccountDao accountDao = (AccountDao) DBDaoFactory.daoFor(Account.class);
      Integer persistedAccountId = accountDao
          .findByUsername(account.getUsername())
          .filter(
              acc -> Objects.equals(account.getPassword(), acc.getPassword()))
          .orElseThrow(RuntimeException::new).getRole_id();
      account.setRole_id(persistedAccountId);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // public
}
