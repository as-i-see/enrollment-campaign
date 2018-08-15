package ua.thydope.finalproject.component.subject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.thydope.finalproject.component.api.JDBCDAO;

public final class JDBCSubjectDAO extends JDBCDAO implements SubjectDAO {

  public JDBCSubjectDAO(Connection connection) {
    super(connection);
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
    try (Statement query = super.connection.createStatement();
        ResultSet subject = query
            .executeQuery("SELECT id, name FROM subjects")) {
      List<Subject> list = new ArrayList<>();
      while (subject.next()) {
        int id = subject.getInt(1);
        String name = subject.getString(2);
        list.add(new Subject(id, name));
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
    super.connection.close();
  }

}
