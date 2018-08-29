package ua.thydope.finalproject.component.account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import javax.sql.DataSource;

import ua.thydope.finalproject.component.api.DBDaoFactory;
import ua.thydope.finalproject.component.api.MapperRegistry;

public class AccountService {
  private DataSource dataSource;

  public AccountService(DataSource dataSource) {
    this.dataSource = dataSource;
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
      AccountDBDao accountDBDao = (AccountDBDao) DBDaoFactory
          .daoFor(Account.class);
      Account persistedAccount = accountDBDao
          .findByUsername(account.getUsername())
          .filter(
              acc -> Objects.equals(account.getPassword(), acc.getPassword()))
          .orElseThrow(RuntimeException::new);
      account.setRole(persistedAccount.getRole());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void register(Account account) {
    try (Connection connection = dataSource.getConnection()) {
      DBDaoFactory.use(connection);
      MapperRegistry.use(DBDaoFactory.getInstance());
      AccountDBDao accountDBDao = (AccountDBDao) DBDaoFactory
          .daoFor(Account.class);
      accountDBDao.findByUsername(account.getUsername())
          .ifPresent((Account acc) -> {
            throw new RuntimeException();
          });
      accountDBDao.create(account);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // public
}
