package ua.thydope.finalproject.component.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcAccountDao implements AccountDao {

  private Connection connection;

  public JdbcAccountDao(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void create(Account entity) {
    try (PreparedStatement query =
        this.connection.prepareStatement(
            "INSERT INTO account " + "(username, password, role) VALUES (?, ?, 'USER')")) {
      query.setString(1, entity.username);
      query.setString(2, entity.password);
      try (ResultSet resultSet = query.executeQuery()) {}
    } catch (SQLException e) {
      e.printStackTrace();
    }
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
    try (PreparedStatement query =
        this.connection.prepareStatement("SELECT password, role FROM account WHERE username=?")) {
      query.setString(1, username);
      try (ResultSet account = query.executeQuery()) {
        if (account.next()) {
          String password = account.getString("password");
          String role = account.getString("role");
          return Optional.of(new Account(username, password, role));
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
