package ua.thydope.finalproject.component.enrollee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.thydope.finalproject.component.api.DBDao;
import ua.thydope.finalproject.controller.converter.ResultSetConverter;

public class EnrolleeDao extends DBDao<Enrollee> {
  public EnrolleeDao(Connection connection) {
    super(connection);
  }

  @Override
  public List<Enrollee> findAll() {
    return null;
  }

  @Override
  public void update(Enrollee entity) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  protected String getCreateQuery() {
    return "INSERT INTO enrollee (account_id, first_name, last_name, email, "
        + "phone_number) VALUES (?, ?, ?, ?, ?)";
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
  protected String getFindByKeyQuery() {
    return "SELECT account_id, first_name, last_name, email, phone_number "
        + "FROM enrollee WHERE account_id=?";
  }

  @Override
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
}
