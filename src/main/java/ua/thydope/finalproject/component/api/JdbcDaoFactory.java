package ua.thydope.finalproject.component.api;

import java.sql.Connection;

import ua.thydope.finalproject.component.account.JdbcAccountDao;
import ua.thydope.finalproject.component.subject.JdbcSubjectDao;

public final class JdbcDaoFactory implements DaoFactory {

  private Connection connection;

  public JdbcDaoFactory(Connection connection) {
    this.connection = connection;
  }

  @Override
  public GenericDao<? extends Distinguishable> getDao(Class<? extends Distinguishable> klass) {
    switch (klass.getName()) {
      case "Account":
        return new JdbcAccountDao(this.connection);
      case "Subject":
        return new JdbcSubjectDao(this.connection);
    }
    return null;
  }
}
