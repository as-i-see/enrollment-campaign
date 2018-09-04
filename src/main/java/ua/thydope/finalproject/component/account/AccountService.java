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
      MapperRegistry.restart();
      AccountDao accountDao = (AccountDao) DBDaoFactory.daoFor(Account.class);
      Account persistedAccount = accountDao
          .findByUsername(account.getUsername())
          .filter(
              acc -> Objects.equals(account.getPassword(), acc.getPassword()))
          .orElseThrow(RuntimeException::new);
      account.setId(persistedAccount.getId());
      account.setRole_id(persistedAccount.getRole_id());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
