package ua.thydope.finalproject.component.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import ua.thydope.finalproject.component.api.DBDao;
import ua.thydope.finalproject.controller.converter.ResultSetConverter;

public class AccountDBDao extends DBDao<Account> {

  public AccountDBDao(Connection connection) {
    super(connection);
  }

  @Override
  protected String getCreateQuery() {
    return "INSERT INTO account "
        + "(username, password, role_id) VALUES (?, ?, ?)";
  }

  @Override
  protected String getFindByKeyQuery() {
    return "SELECT id, username, password, role_id FROM account WHERE id=?";
  }

  @Override
  protected void executeCreate(PreparedStatement ps, Account entity) {
    try {
      ps.setString(1, entity.getUsername());
      ps.setString(2, entity.getPassword());
      ps.setInt(3, AccountType.USER.getIndex());
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected ResultSetConverter<Account> converter() {
    return (ResultSet rs) -> {
      Account account = null;
      try {
        rs.next();
        Integer id = rs.getInt(1);
        String username = rs.getString(2);
        String pwd = rs.getString(3);
        String role = "ADMIN";
        account = new Account(id, username, pwd, role);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return account;
    };
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

  public Optional<Account> findByUsername(String username) {
    PreparedStatement ps = getPreparedStatement(getFindByUsernameQuery());
    ResultSet rs = executeFindByUsername(ps, username);
    Account account = converter().apply(rs);
    DBDao.closeStatement(ps);
    return Optional.ofNullable(account);
  }

  private String getFindByUsernameQuery() {
    return "SELECT id, username, "
        + "password, role_id FROM account WHERE username=?";
  }

  private ResultSet executeFindByUsername(PreparedStatement ps, String key) {
    ResultSet rs = null;
    try {
      ps.setString(1, key);
      rs = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  @Override
  public List<Account> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Account entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub

  }
}
