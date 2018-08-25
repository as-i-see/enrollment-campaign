package ua.thydope.finalproject.component.account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

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
  public Optional<Account> authorize(String username, String pwd) {
    try (Connection connection = dataSource.getConnection()) {
      DBDaoFactory.use(connection);
      MapperRegistry.use(DBDaoFactory.getInstance());
      AccountDBDao accountDBDao = (AccountDBDao) DBDaoFactory
          .daoFor(Account.class);
      return accountDBDao.findByUsername(username)
          .filter(acc -> Objects.equals(pwd, acc.getPassword()));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
