package ua.thydope.finalproject.component.api;

import java.sql.Connection;

import ua.thydope.finalproject.component.account.AccountDao;
import ua.thydope.finalproject.component.enrollee.EnrolleeDao;
import ua.thydope.finalproject.component.role.RoleDao;

public class DBDaoFactory implements DaoFactory {
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

  public static <T extends Entity> Dao<T> daoFor(Class<T> klass) {
    return getInstance().getDao(klass);
  }

  @Override
  public <T extends Entity> Dao<T> getDao(Class<T> klass) {
    switch (klass.getSimpleName()) {
    case "Account":
      return (Dao<T>) new AccountDao(getInstance().connection);
    case "Role":
      return (Dao<T>) new RoleDao(getInstance().connection);
    case "Enrollee":
      return (Dao<T>) new EnrolleeDao(getInstance().connection);
    default:
      return null;
    }
  }
}
