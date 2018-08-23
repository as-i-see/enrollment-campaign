package ua.thydope.finalproject.component.subject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class JdbcSubjectDao implements SubjectDao {

  private Connection connection;

  public JdbcSubjectDao(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void create(Subject entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public Subject findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Subject> findAll() {
    try (Statement query = this.connection.createStatement();
        ResultSet subject = query.executeQuery("SELECT name FROM subject")) {
      List<Subject> list = new ArrayList<>();
      while (subject.next()) {
        String name = subject.getString(1);
        list.add(new Subject(name));
      }
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }

  @Override
  public void update(Subject entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub
  }
}
