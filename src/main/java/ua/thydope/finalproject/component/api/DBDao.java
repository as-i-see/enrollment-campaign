package ua.thydope.finalproject.component.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import ua.thydope.finalproject.controller.converter.ResultSetConverter;

public abstract class DBDao<T extends Entity> implements Dao<T> {
  protected Connection connection;
  protected Queries queries;

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

  protected abstract void executeCreate(PreparedStatement ps, T entity);

  @Override
  public List<T> findAll() {
    return null;
  }

  @Override
  public void update(T entity) {
    PreparedStatement updateStatement = getPreparedStatement(queries.update());
    executeUpdate(updateStatement, entity);
    closeStatement(updateStatement);
  }

  protected void executeUpdate(PreparedStatement ps, T entity) {
  }

  @Override
  public void delete(Integer id) {

  }

  protected abstract ResultSetConverter<T> converter();

  public void create(T entity) {
    PreparedStatement createStatement = getPreparedStatement(queries.create());
    executeCreate(createStatement, entity);
    closeStatement(createStatement);
  }

  public T find(Integer key) {
    PreparedStatement findStatement = getPreparedStatement(queries.find());
    ResultSet rs = executeFind(findStatement, key);
    T entity = converter().apply(rs);
    closeStatement(findStatement);
    return entity;
  }

  protected ResultSet executeFind(PreparedStatement ps, Integer key) {
    ResultSet rs = null;
    try {
      ps.setInt(1, key);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
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

  protected interface Queries {
    default String create() {
      return "";
    }

    default String find() {
      return "";
    }

    default String findAll() {
      return "";
    }

    default String update() {
      return "";
    }

    default String delete() {
      return "";
    }
  }

}
