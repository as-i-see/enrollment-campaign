package ua.thydope.finalproject.component.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.thydope.finalproject.component.api.DBDao;
import ua.thydope.finalproject.controller.converter.ResultSetConverter;

public class SubjectDao extends DBDao<Subject> {

  public SubjectDao(Connection connection) {
    super(connection);
    queries = new SubjectQueries();
  }

  @Override
  protected void executeCreate(PreparedStatement ps, Subject entity) {

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

  private class SubjectQueries implements Queries {
    @Override
    public String find() {
      return "SELECT id, name FROM subject WHERE id=?";
    }
  }
}
