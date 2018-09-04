package ua.thydope.finalproject.component.enrollee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.thydope.finalproject.component.api.DBDao;
import ua.thydope.finalproject.controller.converter.ResultSetConverter;

public class EnrolleeDao extends DBDao<Enrollee> {
  public EnrolleeDao(Connection connection) {
    super(connection);
    queries = new EnrolleeQueries();
  }

  @Override
  protected void executeCreate(PreparedStatement ps, Enrollee entity) {
    try {
      ps.setInt(1, entity.getId());
      ps.setString(2, entity.getFirstName());
      ps.setString(3, entity.getLastName());
      ps.setString(4, entity.getEmail());
      ps.setString(5, entity.getPhone());
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected ResultSetConverter<Enrollee> converter() {
    return (ResultSet rs) -> {
      Enrollee enrollee = null;
      try {
        rs.next();
        Integer account_id = rs.getInt(1);
        String fName = rs.getString(2);
        String lName = rs.getString(3);
        String email = rs.getString(4);
        String phone = rs.getString(5);
        enrollee = new Enrollee(account_id, fName, lName, email, phone);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return enrollee;
    };
  }

  private class EnrolleeQueries implements Queries {
    @Override
    public String create() {
      return "INSERT INTO enrollee (account_id, first_name, last_name, email, "
          + "phone_number) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public String find() {
      return "SELECT account_id, first_name, last_name, email, phone_number "
          + "FROM enrollee WHERE account_id=?";
    }
  }
}
