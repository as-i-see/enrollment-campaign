package ua.thydope.finalproject.component.enrollee;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import ua.thydope.finalproject.component.account.Account;
import ua.thydope.finalproject.component.account.AccountDao;
import ua.thydope.finalproject.component.api.DBDaoFactory;

public class EnrolleeService {
  private DataSource dataSource;

  public EnrolleeService(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void register(Account account) {
    try (Connection connection = dataSource.getConnection()) {
      DBDaoFactory.use(connection);
      AccountDao accountDao = (AccountDao) DBDaoFactory.daoFor(Account.class);
      Integer accountGenerated = accountDao.createAndReturnPk(account);

      Enrollee enrollee = account.getEnrollee();
      enrollee.setId(accountGenerated);
      EnrolleeDao enrolleeDao = (EnrolleeDao) DBDaoFactory
          .daoFor(Enrollee.class);
      enrolleeDao.create(enrollee);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
