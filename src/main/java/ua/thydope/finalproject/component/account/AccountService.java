package ua.thydope.finalproject.component.account;

import java.sql.Connection;
import java.util.Objects;
import java.util.Optional;

import ua.thydope.finalproject.component.api.DaoFactory;
import ua.thydope.finalproject.component.api.JdbcDaoFactory;
import ua.thydope.finalproject.component.api.MapperRegistry;
import ua.thydope.finalproject.component.api.Transaction;

public class AccountService {
    private Connection connection;

    public AccountService(Connection connection) {
        this.connection = connection;
    }

  /**
   * Returns optional role name of given credentials
   *
   * @param the username
   * @param the pwd
   * @return optional role name
   */
  public Optional<Account> authorize(String username, String pwd) {
      DaoFactory daoFactory = new JdbcDaoFactory(this.connection);
      //MapperRegistry mapperRegistry = new MapperRegistry(daoFactory);
      AccountDao accountDao = (AccountDao) daoFactory.getDao(Account.class);
      //Transaction transaction = new Transaction();
      //transaction.commit(this.connection);
    return accountDao.findByUsername(username)
        .filter(acc -> Objects.equals(pwd, acc.password));
  }
}
