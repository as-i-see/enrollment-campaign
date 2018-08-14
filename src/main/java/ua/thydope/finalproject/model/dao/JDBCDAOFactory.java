package ua.thydope.finalproject.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.thydope.finalproject.model.subject.JDBCSubjectDAO;
import ua.thydope.finalproject.model.subject.SubjectDAO;

public final class JDBCDAOFactory extends DAOFactory {

  @Override
  public SubjectDAO subjectDAO() {
    return new JDBCSubjectDAO(newConnection());
  }

  private Connection newConnection() {
    try {
      return DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/form_db?serverTimezone=UTC", "root",
          "1337");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

}
