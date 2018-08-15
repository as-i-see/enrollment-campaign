package ua.thydope.finalproject.component.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.thydope.finalproject.component.subject.JDBCSubjectDAO;
import ua.thydope.finalproject.component.subject.SubjectDAO;

public final class JDBCDAOFactory extends DAOFactory {

  @Override
  public SubjectDAO subjectDAO() {
    return new JDBCSubjectDAO(newConnection());
  }

  private static Connection newConnection() {
    try {
      return DriverManager.getConnection(
          "jdbc:mysql://127.0.0.1:3306/enrollment?serverTimezone=UTC", "root",
          "1337");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

}
