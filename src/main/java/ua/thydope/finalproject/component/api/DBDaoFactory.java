package ua.thydope.finalproject.component.api;

import java.sql.Connection;

import ua.thydope.finalproject.component.account.AccountDao;
import ua.thydope.finalproject.component.assessment.AssessmentDao;
import ua.thydope.finalproject.component.enrollee.EnrolleeDao;
import ua.thydope.finalproject.component.role.RoleDao;
import ua.thydope.finalproject.component.subject.SubjectDao;

public class DBDaoFactory {
  private static ThreadLocal<DBDaoFactory> localInstance = new ThreadLocal<>();

  private Connection connection;

  private DBDaoFactory(Connection connection) {
    this.connection = connection;
  }

  public static DBDaoFactory getInstance() {
    return localInstance.get();
  }

  public static void use(Connection connection) {
    localInstance.set(new DBDaoFactory(connection));
  }

  public static <T extends Entity> DBDao<?> daoFor(Class<T> klass) {
    Connection currentConnection = getInstance().connection;
    switch (klass.getSimpleName()) {
    case "Account":
      return new AccountDao(currentConnection);
    case "Role":
      return new RoleDao(currentConnection);
    case "Enrollee":
      return new EnrolleeDao(currentConnection);
    case "Subject":
      return new SubjectDao(currentConnection);
    case "Assessment":
      return new AssessmentDao(currentConnection);
    default:
      return null;
    }
  }
}
