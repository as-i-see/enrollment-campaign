package ua.thydope.finalproject.component.api;

import java.sql.Connection;

public abstract class DBDao<T extends Entity> implements GenericDao<T> {
  private Connection connection;

  public DBDao(Connection connection) {
    this.connection = connection;
  }
}
