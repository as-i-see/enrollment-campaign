package ua.thydope.finalproject.component.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.thydope.finalproject.component.api.DBDao;
import ua.thydope.finalproject.controller.converter.ResultSetConverter;

public class SubjectDao extends DBDao<Subject> {

  public SubjectDao(Connection connection) {
    super(connection);
  }

  @Override
  protected String getCreateQuery() {
    return null;
  }

  @Override
  protected void executeCreate(PreparedStatement ps, Subject entity) {

  }

  @Override
  protected String getFindByKeyQuery() {
    return "SELECT id, name FROM subject WHERE id=?";
  }

  @Override
  protected ResultSetConverter<Subject> converter() {
    return (ResultSet rs) -> {
      Subject subject = null;
      try {
        rs.next();
        Integer id = rs.getInt(1);
        String name = rs.getString(2);
        subject = new Subject(id, name);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return subject;
    };
  }

  @Override
  public void create(Subject entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public List<Subject> findAll() {
    return null;
  }

  @Override
  public void update(Subject entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub

  }
}
