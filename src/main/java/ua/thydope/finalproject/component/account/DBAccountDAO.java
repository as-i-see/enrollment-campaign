package ua.thydope.finalproject.component.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import ua.thydope.finalproject.component.api.JDBCDAO;

public class DBAccountDAO extends JDBCDAO implements AccountDAO {

  public DBAccountDAO(Connection connection) {
    super(connection);
  }

  @Override
  public void create(Account entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public Account findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Account> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<Account> findByUsername(String username) {
    try (PreparedStatement query = super.connection.prepareStatement(
        "SELECT username, password, role, enrollee_id FROM users WHERE username=?")) {
      query.setString(1, username);
      try (ResultSet account = query.executeQuery()) {
        if (account.next()) {
          String password = account.getString("password");
          String role = account.getString("role");
          int enrolleeId = account.getInt("enrollee_id");
          return Optional.of(new Account(username, password, role, enrolleeId));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public void update(Account entity) {
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
