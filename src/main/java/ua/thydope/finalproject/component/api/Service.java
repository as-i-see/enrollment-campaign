package ua.thydope.finalproject.component.api;

import javax.sql.DataSource;

public abstract class Service {
  protected DataSource dataSource;

  public Service(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}
