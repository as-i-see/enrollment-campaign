package ua.thydope.finalproject.component.api;

import java.sql.Connection;

import ua.thydope.finalproject.component.account.AccountDBDao;
import ua.thydope.finalproject.component.subject.SubjectDBDao;

public class DBDaoFactory implements DaoFactory, AutoCloseable {
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
      return (Dao<T>) new AccountDBDao(getInstance().connection);
    case "Subject":
      return (Dao<T>) new SubjectDBDao(getInstance().connection);
    }
    return null;
  }

  @Override
  public void close() {
    localInstance.set(null);
  }
}
