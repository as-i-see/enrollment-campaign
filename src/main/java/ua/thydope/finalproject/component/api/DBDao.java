package ua.thydope.finalproject.component.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

import ua.thydope.finalproject.controller.converter.ResultSetConverter;

// TODO all queries to abstract factory
public abstract class DBDao<T extends Entity> implements Dao<T> {
  protected Connection connection;

  public DBDao(Connection connection) {
    this.connection = connection;
  }

  protected static void closeStatement(PreparedStatement ps) {
    if (Objects.nonNull(ps)) {
      try {
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  protected abstract String getCreateQuery();

  protected abstract void executeCreate(PreparedStatement ps, T entity);

  protected abstract String getFindByKeyQuery();

  protected abstract ResultSet executeFind(PreparedStatement ps, Integer key);

  protected abstract ResultSetConverter<T> converter();

  public void create(T entity) {
    PreparedStatement createStatement = getPreparedStatement(getCreateQuery());
    executeCreate(createStatement, entity);
    closeStatement(createStatement);
  }

  public Optional<T> find(Integer key) {
    PreparedStatement createStatement = getPreparedStatement(
        getFindByKeyQuery());
    ResultSet rs = executeFind(createStatement, key);
    T entity = converter().apply(rs);
    closeStatement(createStatement);
    return Optional.ofNullable(entity);
  }

  protected PreparedStatement getPreparedStatement(String query) {
    PreparedStatement ps = null;
    try {
      ps = connection.prepareStatement(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ps;
  }

}
