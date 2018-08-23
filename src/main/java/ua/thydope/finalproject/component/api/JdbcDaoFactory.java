package ua.thydope.finalproject.component.api;

import java.sql.Connection;
import java.sql.DriverManager;

import ua.thydope.finalproject.component.account.AccountDao;
import ua.thydope.finalproject.component.account.JdbcAccountDao;
import ua.thydope.finalproject.component.subject.JdbcSubjectDao;
import ua.thydope.finalproject.component.subject.SubjectDao;

public final class JdbcDaoFactory implements DaoFactory {

  private Connection connection;

  public JdbcDaoFactory(Connection connection) {
    this.connection = connection;
  }

  @Override
  public SubjectDao subjectDAO() {
    return new JdbcSubjectDao(this.connection);
  }

  @Override
  public AccountDao accountDAO() {
    return new JdbcAccountDao(this.connection);
  }
}
