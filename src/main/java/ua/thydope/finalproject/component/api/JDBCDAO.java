package ua.thydope.finalproject.component.api;

import java.sql.Connection;

public abstract class JDBCDAO {
  protected Connection connection;

  public JDBCDAO(Connection connection) {
    this.connection = connection;
  }

}
